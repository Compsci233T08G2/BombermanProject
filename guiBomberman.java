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
	
	private Image mapImage;
	private Image wallImage;
	private Image BWallImage;
	private Image bombImage;
	private Map map = new Map();
	private guiBomb bomb1;
	private guiBomb bomb2;
	private Timer timer1;
	private Timer timer2;
	private int interval1;
	private int interval2;
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

		guiPlayer player1 = new guiPlayer(0, 0, "1");
		bomb1 = new guiBomb(player1.getxCord(), player1.getyCord(), player1.getXPositionGUI(),player1.getYPositionGUI());

		guiPlayer player2 = new guiPlayer(7,7,"2");
		bomb2 = new guiBomb(player2.getxCord(), player2.getyCord(), player2.getXPositionGUI(),player2.getYPositionGUI());
		
		
		GameObject.intializingMap(player1, player2);
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
						render(gc, player1,player2);
					}
				}
				if (code == ("RIGHT")) {
					if (player1.move("right", player1)) {
						player1.setPosition(player1.getXPositionGUI() + offset, player1.getYPositionGUI());
						render(gc, player1,player2);
					}
				}

				if (code == ("UP")) {
					if (player1.move("up", player1)) {
						player1.setPosition(player1.getXPositionGUI(), player1.getYPositionGUI() - offset);
						render(gc, player1,player2);
					}
				}

				if (code == ("DOWN")) {
					if (player1.move("down", player1)) {
						player1.setPosition(player1.getXPositionGUI(), player1.getYPositionGUI() + offset);
						render(gc, player1,player2);
					}
				}
				if (code == "SPACE") {
					if (!activeKeys.contains("SPACE")) {
						activeKeys.add("SPACE");
						
						bomb1.setxCord(player1.getxCord());
						bomb1.setyCord(player1.getyCord());
						bomb1.setXcoord(player1.getXPositionGUI());
						bomb1.setYcoord(player1.getYPositionGUI());
						gc.drawImage(bomb1.getBombImage(), bomb1.getXcoord(), bomb1.getYcoord());
						gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());

						bomb1.setBombFlag(true);

						// THIS IS THE TIMER FOR THE BOMB//
						int delay = 1000;
						int period = 1000;
						timer1 = new Timer();
						interval1 = Integer.parseInt("3");
						timer1.scheduleAtFixedRate(new TimerTask() {
							public void run() {
								setInterval(bomb1,code,timer1,"interval1");
								if (!bomb1.getBombFlag())
									render(gc, player1,player2);
								// alive is false
								if (playerAlive) {
									System.out.println("WELCOME TO THE REALM");
									System.exit(0);
								}

							}
						}, delay, period);
					}
				}
				//////////////////////////////////////////PLAYER2 CODE
				if (code == ("A")) {
					if (player2.move("left", player2)) {
						player2.setPosition((player2.getXPositionGUI() - offset), player2.getYPositionGUI());
						render(gc, player1,player2);
					}
				}
				if (code == ("D")) {
					if (player2.move("right", player2)) {
						player2.setPosition(player2.getXPositionGUI() + offset, player2.getYPositionGUI());
						render(gc, player1,player2);
					}
				}

				if (code == ("W")) {
					if (player2.move("up", player2)) {
						player2.setPosition(player2.getXPositionGUI(), player2.getYPositionGUI() - offset);
						render(gc, player1,player2);
					}
				}

				if (code == ("S")) {
					if (player2.move("down", player2)) {
						player2.setPosition(player2.getXPositionGUI(), player2.getYPositionGUI() + offset);
						render(gc, player1,player2);
					}
				}
				if (code == "SHIFT") {
					if (!activeKeys.contains("SHIFT")) {
						activeKeys.add("SHIFT");
						bomb2.setxCord(player2.getxCord());
						bomb2.setyCord(player2.getyCord());
						bomb2.setXcoord(player2.getXPositionGUI());
						bomb2.setYcoord(player2.getYPositionGUI());
						
						gc.drawImage(bomb2.getBombImage(), bomb2.getXcoord(), bomb2.getYcoord());
						gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());

						bomb2.setBombFlag(true);

						// THIS IS THE TIMER FOR THE BOMB//
						int delay = 1000;
						int period = 1000;
						timer2 = new Timer();
						interval2 = Integer.parseInt("3");
						timer2.scheduleAtFixedRate(new TimerTask() {
							public void run() {
					
								setInterval(bomb2,code,timer2,"interval2");
								if (!bomb2.getBombFlag())
									render(gc, player1,player2);
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
		theStage.show();
	}

	private void render(GraphicsContext gc, guiPlayer player1,guiPlayer player2) {
		Image mapImage = new Image("gameboard.png");
		Image UWallImage = new Image("unbreakableWall.png");
		Image BWallImage = new Image("breakableWall.png");
		

		gc.clearRect(0, 0, 600, 600);
		map.makingMapForGui(gc, UWallImage,BWallImage, mapImage);
		
		if(bomb1.getBombFlag()&&bomb2.getBombFlag()) {
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
			gc.drawImage(bomb1.getBombImage(), bomb1.getXcoord(), bomb1.getYcoord());
			gc.drawImage(bomb2.getBombImage(), bomb2.getXcoord(), bomb2.getYcoord());
		}
		else if(bomb1.getBombFlag()&& !bomb2.getBombFlag()){
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
			gc.drawImage(bomb1.getBombImage(), bomb1.getXcoord(), bomb1.getYcoord());

		}
		else if(!bomb1.getBombFlag()&&bomb2.getBombFlag()) {
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
			gc.drawImage(bomb2.getBombImage(), bomb2.getXcoord(), bomb2.getYcoord());	
		}
		else {
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
		}
	}

	
	private int setInterval(guiBomb bomb,String keyToRemove,Timer timer,String interval) {
		if(interval == "interval1") {
		if (interval1 == 1) {
			System.out.println("im here");
			timer.cancel();
			bomb.setBombFlag(false);
			activeKeys.remove(keyToRemove);
			playerAlive = bomb.Blown();
		}
		return --interval1;
		}
		if(interval == "interval2") {
		if (interval2 == 1) {
			System.out.println("im here");
			timer.cancel();
			bomb.setBombFlag(false);
			activeKeys.remove(keyToRemove);
			playerAlive = bomb.Blown();
		}
		return --interval2;
		}
		return 0;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
