import javafx.animation.AnimationTimer;
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
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

public class guiBomberman extends Application {
    private boolean running = false;
    private Thread thread; // might use this but not sure
    private BufferStrategy getBufferStrategy() {
        return this.getBufferStrategy(); } // getter for bs which is used for graphics 2d
    private void createBufferStrategy(int i) { }
    //private Handler handler;

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bomberman Game");
        primaryStage.setScene(new Scene(root, 800, 475));
        primaryStage.show();
    }*/
    public static void main(String[] args) {

        launch(args);
    }
    public void start(Stage theStage){
        theStage.setTitle("Bomberman game");
        Group root = new Group();
        Scene theScene = new Scene(root,550,550);
        theStage.setScene(theScene);


        Canvas canvas = new Canvas(1200, 800);
        root.getChildren().add(canvas);

        //handler = new Handler();
       // handler.addObject((new Player(100, 100, ID.Player)));
        ArrayList<String> currentlyActiveKeys = new ArrayList<String>();
        ArrayList<Sprite> currentlyActiveSprites = new ArrayList<Sprite>();

        
        Image map = new Image("FullGameBoard.png");
        Image player1Image = new Image("Player1_1.png");
        Sprite player1 = new Sprite(player1Image,0,0);
        
        
       // root.getChildren().add(player1);
        //theStage.show();
        
        currentlyActiveSprites.add(player1);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage( map, 0, 0 );
        

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){
                    @Override
                    public void handle(KeyEvent event) {
                    	double offset=62.5;
                        String code = event.getCode().toString();
                        if (code==("LEFT")) {
                        	gc.clearRect(0,0,600,600);
                        	gc.drawImage( map, 0, 0 );
                        	player1.setPosition((player1.getXPosition()-offset), player1.getYPosition());
                        	player1.render(gc);
                        }
                        if (code==("RIGHT")) {
                        	gc.clearRect(0,0,600,600);
                        	gc.drawImage( map, 0, 0 );
                    		player1.setPosition(player1.getXPosition()+offset, player1.getYPosition());
                    		player1.render(gc);
                        }

                        if (code==("UP")) {
                        	gc.clearRect(0,0,600,600);
                        	gc.drawImage( map, 0, 0 );
                    		player1.setPosition(player1.getXPosition(), player1.getYPosition()-offset);
                        	player1.render(gc);
                        }

                        if (code==("DOWN")) {
                        	gc.clearRect(0,0,600,600);
                        	gc.drawImage( map, 0, 0 );
                			player1.setPosition(player1.getXPosition(), player1.getYPosition()+offset);
                        	player1.render(gc);
                        }

                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        String code = event.getCode().toString();
                    	//adds the keys pressed to the arraylist currentlyacticekeys;
                        currentlyActiveKeys.remove(code);
                    }
                });


       // handler.addObject(new Player(100, 40, ID.Player));
        final long startNanoTime = System.nanoTime();

        new AnimationTimer(){
        	//double offset=62.5;
            public void handle(long currentNanoTime)
            {
            	//for
            }
        }.start();
        theStage.show();
    }

    public void stop(){
        try{
            //thread.join();
            running = false;
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
//    private void tick(){
//        handler.tick();
//    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

       // handler.render(g);
        g.dispose();
        bs.show();
    }
    public void run2(){ // the second game loop

    }

    public void run(){ // this is the game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
              //  tick();
                delta--;
            }
            if(running){
                render();
                frames++;
                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    System.out.println("Frames per second " + frames);
                    frames = 0;
                }
            }
            stop();
        }


    }
}
