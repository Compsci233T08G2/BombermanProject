package graphics;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mechanics.GameObject;
import mechanics.Map;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class guiBomberman extends Application {
	private Image playerImage= new Image("Player1_1.png");
	private Image mapImage = new Image("gameboard.png");
	private Image UWallImage = new Image("unbreakableWall.png");
	private Image BWallImage = new Image("breakableWall.png");
	
	private Map map = new Map();
	private guiBomb bomb1;
	private guiBomb bomb2;
	
	//TIMERS FOR BOMB1 AND BOMB2
	private Timer timer1;
	private Timer timer2;
	//INTERVALS FOR TIMERS1 AND TIMERS2
	private int interval1;
	private int interval2;
	private boolean playerAlive;
	private ArrayList<String> activeKeys;
	
	/*
	 * 
	 * 
	 */
	public void start(Stage theStage) {
		/*
		 * Setting up the stage and putting the map on the canvas/
		 */
		theStage.setTitle("Bomberman game");
		Group root = new Group();
		Scene theScene = new Scene(root, 550, 550);
		theStage.setScene(theScene);
		Canvas canvas = new Canvas(1200, 800);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(mapImage, 0, 0);
		
		////////////////////////////////////////////////////////
		//INITIALIZING PLAYER1 AND THE BOMB1
		guiPlayer player1 = new guiPlayer(0, 0, "1",playerImage);
		bomb1 = new guiBomb(player1.getxCord(), player1.getyCord(), player1.getXPositionGUI(),player1.getYPositionGUI());
		//INITIALIZING PLAYER2 AND BOMB2
		guiPlayer player2 = new guiPlayer(7,7,"2",playerImage);
		bomb2 = new guiBomb(player2.getxCord(), player2.getyCord(), player2.getXPositionGUI(),player2.getYPositionGUI());
		
		//INITIALIZING MAP IN THE LOGIC(MECHANICS CLASS)
		GameObject.intializingMap(player1, player2);
		activeKeys = new ArrayList<String>();
		///////////////////////////////////////////////////////

		theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				double offset = 62.5;// THIS IS THE PIXEL SIZE OF EACH TILE//
				String code = event.getCode().toString(); // GETTING THE STRING VALUE FOR THE KEY PRESSED//
				//////////////////////////////////PLAYER 1 CONTROLS
				if (code == ("LEFT")) {
					//CHECKS IN THE PLAYER CAN MOVE IN THIS LOCATION IN THE LOGIC(MECHANICS CLASS) OF THE GAME.
					if (player1.move("left", player1)) {
						//IF THE PLAYER CAN MOVE IN THAT DIRECTION THEN SET THE GUIPLAYER(SPRITE OF THE PLAYER)
						//IN THE DESIRED LOCATION.
						player1.setPosition((player1.getXPositionGUI() - offset), player1.getYPositionGUI());
						//AND RENDERS THE GAME TO THE WITH THE NEW POSITONS
						render(gc, player1,player2);
					}
				}
				if (code == ("RIGHT")) {
					//CHECKS IN THE PLAYER CAN MOVE IN THIS LOCATION IN THE LOGIC(MECHANICS CLASS) OF THE GAME.
					if (player1.move("right", player1)) {
						player1.setPosition(player1.getXPositionGUI() + offset, player1.getYPositionGUI());
						render(gc, player1,player2);
					}
				}

				if (code == ("UP")) {
					//CHECKS IN THE PLAYER CAN MOVE IN THIS LOCATION IN THE LOGIC(MECHANICS CLASS) OF THE GAME.
					if (player1.move("up", player1)) {
						player1.setPosition(player1.getXPositionGUI(), player1.getYPositionGUI() - offset);
						render(gc, player1,player2);
					}
				}

				if (code == ("DOWN")) {
					//CHECKS IN THE PLAYER CAN MOVE IN THIS LOCATION IN THE LOGIC(MECHANICS CLASS) OF THE GAME.
					if (player1.move("down", player1)) {
						player1.setPosition(player1.getXPositionGUI(), player1.getYPositionGUI() + offset);
						render(gc, player1,player2);
					}
				}
				if (code == "SPACE") {
					//CHECKS IF THERES ALREADY A BOMB PLACED BY PLAYER1
					if (!activeKeys.contains("SPACE")) {
						//THIS ENSURES THAT THE ASSIGNED PLAYER CAN ONLY DROP ONE BOMB AT ATIME.
						activeKeys.add("SPACE");
						
						//SETS THE POSITION OF BOMB IN THE LOGIC OF THE GAME
						bomb1.setxCord(player1.getxCord());
						bomb1.setyCord(player1.getyCord());
						//SETS IN THE POSITION IN THE GUI VERSION
						bomb1.setXcoord(player1.getXPositionGUI());
						bomb1.setYcoord(player1.getYPositionGUI());
						
						gc.drawImage(bomb1.getBombImage(), bomb1.getXcoord(), bomb1.getYcoord());
						gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());

						
						//BOMBFLAG INDICATES THAT THIS BOMB IS CURRENTLY ACTIVE
						bomb1.setBombFlag(true);
						
						//THIS IS THE TIMER FOR THE BOMB//
						int delay = 1000;
						int period = 1000;
						timer1 = new Timer();
						interval1 = Integer.parseInt("3");
						timer1.scheduleAtFixedRate(new TimerTask() {
							public void run() {
								//CONTINOUSLY CALLS THE SETINTERVAL TO MAKE CHANGES WHEN THIS BOMB BLOWS UP.
								setInterval(bomb1,code,timer1,"interval1");
								
								//WHEN THE BOMB IS BLOWN, THE CONDITION FOR THIS IF-STATEMENT IS SATISFIED.
								//AND THE MAP IS RENDERED WITHOUT THE BOMB NOW.
								if (!bomb1.getBombFlag())
									render(gc, player1,player2);
								
								//IF (PLAYERALIVE = TRUE), IT IMPLIES THAT THE PLAYER IS DEAD AND THE GAME ENDS.
								if (playerAlive) {
									System.out.println("PLAYER1 DIED");
									System.exit(0);
								}

							}
						}, delay, period);
					}
				}
				//////////////////////////////////////////PLAYER2 CODE
				//////////////////THIS SECTION WORKS IN THE SAME MANNER AS ABOVE.
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
								if (playerAlive) {
									System.out.println("PLAYER2 DIED");
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

	/*
	 * RENDERS THE MAP,PLAYERS AND THE BOMB EVERYTIME SOME MOVEMENT TAKE PLACE IN THE GAME.
	 * TAKES IN ARGUMENT THE GRAPHICS CONTEXT AND THE TWO PLAYER THAT ARE TO BE RENDERED.
	 */
	private void render(GraphicsContext gc, guiPlayer player1,guiPlayer player2) {
		
		gc.clearRect(0, 0, 600, 600);
		map.makingMapForGui(gc, UWallImage,BWallImage, mapImage);
		
		//RENDERS WHEN PLAYER1, PLAYER2 AND BOMB1, BOMB2
		if(bomb1.getBombFlag()&&bomb2.getBombFlag()) {
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
			gc.drawImage(bomb1.getBombImage(), bomb1.getXcoord(), bomb1.getYcoord());
			gc.drawImage(bomb2.getBombImage(), bomb2.getXcoord(), bomb2.getYcoord());
		}
		//RENDERS WITH PLAYER1,PLYAER2 AND JUST BOMB1
		else if(bomb1.getBombFlag()&& !bomb2.getBombFlag()){
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
			gc.drawImage(bomb1.getBombImage(), bomb1.getXcoord(), bomb1.getYcoord());

		}
		
		//RENDERS  WITH PLAYER1, PLAYER2 AND JUST BOMB2
		else if(!bomb1.getBombFlag()&&bomb2.getBombFlag()) {
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
			gc.drawImage(bomb2.getBombImage(), bomb2.getXcoord(), bomb2.getYcoord());	
		}
		//RENDERS WITH JUST PLAYER1 AND PLAYER2
		else {
			gc.drawImage(player1.getImage(), player1.getXPositionGUI(), player1.getYPositionGUI());
			gc.drawImage(player2.getImage(), player2.getXPositionGUI(), player2.getYPositionGUI());
		}
	}

	/*
	 * THIS FUNCTION IS CALLED CONTINOUSLY WHEN THE BOMB DROPPED IN THE GAME.
	 * TAKES IN ARGUMENT THE INSTANCE OF THE BOMB, THE KEY THAT DROPS THE GIVEN BOMB,
	 * THE TIMER ASSOCIATED WITH THE BOMB AND THE INTERVAL ASSOCIATED WITH THE TIMER.
	 */
	private int setInterval(guiBomb bomb,String keyToRemove,Timer timer,String interval){
		//INTERVAL1 WORKS WITH BOMB1
		if(interval == "interval1") {
		if (interval1 == 1) {
			//TIMER1 GET CANCELLED
			timer.cancel();
			//SETBOMBFLAG(THAT INDICATES IF THE BOMB IS ACTIVE) IS SET AS FALSE.
			bomb.setBombFlag(false);
			
			//REMOVES THE KEY THAT IS USED TO DROP THE BOMB FROM THE ARRAYLIST
			//SO THAT THE GIVEN PLAYER IS ENABLED TO DROP THE BOMB AGAIN ONCE THIS ONE GOES OFF.
			activeKeys.remove(keyToRemove);
			
			//CALLS METHOD FROM THE LOGIC(MECHANICS CLASS) OF THE GAME TO CHECK IF THE PLAYER IF
			//ALIVE AFTER THE BOMB IS BLOWN UP.
			playerAlive = bomb.Blown();
		}
		return --interval1;
		}
		//INTERVAL2 WORKS WITH BOMB2
		// IT WORKS IN THE SAME MANNER AS ABOVE.
		if(interval == "interval2") {
		if (interval2 == 1) {
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
