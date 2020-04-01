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

public class Main extends Application {
    private boolean running = false;
    private Thread thread; // might use this but not sure
    private BufferStrategy getBufferStrategy() {
        return this.getBufferStrategy(); } // getter for bs which is used for graphics 2d
    private void createBufferStrategy(int i) { }
    private Handler handler;

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
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1200, 800);
        root.getChildren().add(canvas);

        handler = new Handler();
        handler.addObject((new Player(100, 100, ID.Player)));
        ArrayList<String> input = new ArrayList<String>();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent event) {
                        String code = event.getCode().toString();
                        //to prevent duplicates
                        if(!input.contains(code) )
                            input.add(code);
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {

                        String code = event.getCode().toString();
                        input.remove( code );
                    }
                });

        GraphicsContext gc = canvas.getGraphicsContext2D();
        /*
        gc.setFill(Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "This is the static game map", 60, 50 );
        gc.strokeText( "This is the static game map", 60, 50 );
        */

        Image map = new Image("FullGameBoard.png");
        Image player1 = new Image("Player1.png");
        //here we need to add all of the players and items
        //gc.drawImage(map, 100, 60);
        //here we are moving the player
        /*AnimatedImage movePlayer = new AnimatedImage();
        Image[] imageArray = new Image[6];
        for (int i = 0; i < 4; i++)
            imageArray[i] = new Image( "player1_" + i + ".png" );
        movePlayer.frames = imageArray;
        movePlayer.duration = 0.100;*/

        AnimatedImage movePlayer = new AnimatedImage();
        Image[] imageArray = new Image[6];
        for (int i = 0; i < 6; i++)
            imageArray[i] = new Image("Player1_" + i + ".png");
        movePlayer.frames = imageArray;
        movePlayer.duration = 0.100;

        handler.addObject(new Player(100, 40, ID.Player));
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {

                double t = (currentNanoTime - startNanoTime) / 1000000000.0;


                /*if (input.contains("Player1"))
                    gc.drawImage( player1, 64, 64 );
                else
                    gc.drawImage( player1, 64, 64 );

                if (input.contains("Player1"))
                    gc.drawImage( player1, 256, 64 );
                else
                    gc.drawImage( player1, 256, 64 );*/


                /*ArrayList<Sprite> bombermanList = new ArrayList<Sprite>();
                for (int i = 0; i < 15; i++)
                {
                    Sprite bombman = new Sprite();
                    bombman.setPicture("player1.png");
                    double px = 350 * Math.random() + 50;
                    double py = 350 * Math.random() + 50;
                    bombman.setPosition(px,py);
                    bombermanList.add( bombman );
                }*/
                //gc.drawImage(bomberman, 5, 10);
               /* gc.clearRect(0, 0, 1200, 800);*/
                //add keylisteners here

                  //  gc.drawImage(player1, Math.addExact(1, 0), Math.addExact(0, 1));
                //here we need to add movement
                double x = 232 + 128 * Math.cos(t);
                //double x = 100 + 60 * Math.addExact(1, 0); // moves right
                //double y = 100 + 60;
                double y = 232 + 128 * Math.sin(t);


                // background image clears canvas and draw the players and items
                //gc.drawImage(map, 0, 0 );
                //gc.clearRect(0, 0, 1200, 800 );

                Sprite map = new Sprite();
                map.setPosition(0,0);
                map.setPicture("FullGameBoard.png");
                map.render(gc);
                Sprite bomberman = new Sprite();
                bomberman.setPicture("Player1.png");
                bomberman.setPosition(40, 80);
                bomberman.render( gc);
                //bomberman.addVelocity(1, 0);
                bomberman.setVelocity(20,0);
                gc.drawImage(movePlayer.getFrame(t), 500, 30);

                //gc.drawImage(movePlayer.getFrame(t), 450, 25);
               // gc.drawImage(player1, x, y);
            }
        } .start();

        theStage.show();
    }

    public void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
    private void tick(){
        handler.tick();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
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
                tick();
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
