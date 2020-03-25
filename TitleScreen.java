package application;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class TitleScreen extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Button 1
        Label label1 = new Label("Welcome to BomberMan");
        Button button1 = new Button("Play Text-Based Game");
        button1.setOnAction(e -> window.setScene(scene2));
        
      //Button 2
        Button button2 = new Button("This will be the game, go back to the title");
        button2.setOnAction(e -> window.setScene(scene1));

        
        //Button 3
        Button button3 = new Button("Play GUI-Based Game");
        button3.setOnAction(e -> window.setScene(scene2));


        //Layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button3);
        scene1 = new Scene(layout1, 300, 250);

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 300, 250);

        window.setScene(scene1);
        window.setTitle("BomberMan");
        window.show();
    }

}