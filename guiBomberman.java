package graphics;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import mechanics.Bomb;
import mechanics.GameObject;
import mechanics.Map;
import mechanics.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

public class guiBomberman extends Application {
	private static boolean flag = false;
	private Image mapImage;
	private Image wallImage;
	private Image bombImage;

	private Map map = new Map();
	private guiBomb bomb;
	private Timer timer;
	private int interval;
	private boolean playerAlive;
	private ArrayList<String> activeKeys;

	public void start(Stage theStage) {
		theStage.setTitle("Bomberman game");
		Group root = new Group();
		Scene theScene = new Scene(root, 550, 550);
		theStage.setScene(theScene);
		Canvas canvas = new Canvas(1200, 800);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image mapImage = new Image("gameboard.png");

		gc.drawImage(mapImage, 0, 0);
		////////////////////////////////////////////////////////

		guiPlayer player1 = new guiPlayer(0, 0, "l");
		GameObject.intializingMap(player1, null);
		bombImage = new Image("bombermanBomb.png");
		activeKeys = new ArrayList<String>();

		///////////////////////////////////////////////////////

		theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				double offset = 62.5;// THIS IS THE PIXEL SIZE OF EACH TILE//
				String code = event.getCode().toString(); // GETTING THE STRING VALUE FOR THE KEY PRESSED//
				if (code == ("LEFT")) {
					if (player1.move("left", player1)) {
						player1.setPosition((player1.getXPositionGUI() - offset), player1.getYPositionGUI());
						render(gc, player1);
					}
				}
				if (code == ("RIGHT")) {
					if (player1.move("right", player1)) {
						player1.setPosition(player1.getXPositionGUI() + offset, player1.getYPositionGUI());
						render(gc, player1);
					}
				}

				if (code == ("UP")) {
					if (player1.move("up", player1)) {
						player1.setPosition(player1.getXPositionGUI(), player1.getYPositionGUI() - offset);
						render(gc, player1);
					}
				}

				if (code == ("DOWN")) {
					if (player1.move("down", player1)) {
						player1.setPosition(player1.getXPositionGUI(), player1.getYPositionGUI() + offset);
						render(gc, player1);
					}
				}
				if (code == "SHIFT") {
					if (!activeKeys.contains("SHIFT")) {
						activeKeys.add("SHIFT");
						bomb = new guiBomb(player1.getxCord(), player1.getyCord(), player1.getXPositionGUI(),
								player1.getYPositionGUI());
						gc.drawImage(bombImage, bomb.getXcoord(), bomb.getYcoord());
						gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
						flag = true;

						// THIS IS THE TIMER FOR THE BOMB//
						int delay = 1000;
						int period = 1000;
						timer = new Timer();
						interval = Integer.parseInt("3");
						timer.scheduleAtFixedRate(new TimerTask() {
							public void run() {
								setInterval();
								if (!flag)
									render(gc, player1);
								// alive is false
								if (playerAlive) {
									System.out.println("WELCOME TO THE REALM");
									System.exit(0);
								}

							}
						}, delay, period);
					}
				}
			}
		});

//        theScene.setOnKeyReleased(
//                new EventHandler<KeyEvent>() {
//                    @Override
//                    public void handle(KeyEvent event) {
//                        String code = event.getCode().toString();
//                    }
//                });
//        
//        new AnimationTimer(){
//            public void handle(long currentNanoTime)
//            {            	
//        }.start();}
		theStage.show();
	}

	private void render(GraphicsContext gc, guiPlayer player) {
		Image mapImage = new Image("gameboard.png");
		Image wallImage = new Image("unbreakableWall.png");

		gc.clearRect(0, 0, 600, 600);
		map.makingMapForGui(gc, wallImage, mapImage);

		if (flag) {
			gc.drawImage(bombImage, bomb.getXcoord(), bomb.getYcoord());
			gc.drawImage(player.getImage(), player.getXPositionGUI(), player.getYPositionGUI());
		}
		if (!flag) {
			gc.drawImage(player.getImage(), player.getXPositionGUI(), player.getYPositionGUI());
		}
	}

	private final int setInterval() {
		if (interval == 1) {
			System.out.println("im here");
			timer.cancel();
			flag = false;
			activeKeys.remove("SHIFT");
			playerAlive = bomb.Blown();
			// return bomb.Blown();
		}
		return --interval;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
