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

        //Button 1, this creates a button that will play the text-based version of the game
        // when the logic is connected with the GUI the event handlers will change to run the text-based
        Label label1 = new Label("Welcome to BomberMan");
        Button button1 = new Button("Play Text-Based Game");
        button1.setOnAction(e -> window.setScene(scene2));
        
      //Button 2, this creates a temporary button placement that is on the second canvas as a placeholder for the game GUI game screen
        Button button2 = new Button("This will be the game, go back to the title");
        button2.setOnAction(e -> window.setScene(scene1));

        
        //Button 3, this creates a button that will play the GUI game, it currently connects canvas one to canvas two.
        //Once the logic is connected with the GUI this button will load the game on the second canvas.
        Button button3 = new Button("Play GUI-Based Game");
        button3.setOnAction(e -> window.setScene(scene2));


        //Layout 1, this loads the components we need for the second screen.
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button3);
        scene1 = new Scene(layout1, 300, 250);

        //Layout 2, this loads the components we need for the second screen
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 300, 250);
        
        //Setting the initial scene and naming the scenes.
        window.setScene(scene1);
        window.setTitle("BomberMan");
        window.show();
    }

}
