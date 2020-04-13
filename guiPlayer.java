package graphics;

import javafx.scene.image.Image;
import mechanics.*;
import mechanics.Map;
import javafx.scene.canvas.GraphicsContext;

public class guiPlayer {
    //variables player(image) and x and y positions
    private Image playerImage;
    private double positionXGUI;
    private double positionYGUI;
    private double offSet=62.5;

//constructor
    public guiPlayer(int positionX, int positionY,String playerId) {
        super(positionX,positionY,playerId);
        this.positionXGUI = positionX*offSet;
        this.positionYGUI = positionY*offSet;
        this.playerImage = new Image("Player1_1.png");
    }
    //image setter
    public void setImage(Image sprite){
        playerImage = sprite;
    }
//setter - image filename
    public void setImage(String filename){
        Image sprite = new Image(filename);
        setImage(sprite);
    }
//getter
    public Image getImage() {
        return this.playerImage;
    }
//position setter
    public void setPosition(double x, double y){
        positionXGUI = x;
        positionYGUI = y;
    }
//getter
    public double getXPositionGUI() {
        return this.positionXGUI;
    }
//getter
    public double getYPositionGUI() {
        return this.positionYGUI;
    }

//    public boolean intersects(Sprite s)
//    {
//        return s.getBoundary().intersects( this.getBoundary() );
//    }

}
