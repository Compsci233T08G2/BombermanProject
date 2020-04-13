package graphics;
import javafx.scene.image.Image;
import mechanics.*;
import mechanics.Map;
import javafx.scene.canvas.GraphicsContext;




////////////////////////////////////////////////////
public class guiPlayer extends Player{
    private Image playerImage;
    private double positionXGUI;
    private double positionYGUI;
    private double offSet=62.5;


    public guiPlayer(int positionX, int positionY,String playerId) {
    	super(positionX,positionY,playerId);
        this.positionXGUI = positionX*offSet;
        this.positionYGUI = positionY*offSet;
        this.playerImage = new Image("Player1_1.png");

    }

    public void setImage(Image sprite){
        playerImage = sprite;
    }

    public void setImage(String filename){
        Image sprite = new Image(filename);
        setImage(sprite);
    }
    
    public Image getImage() {
    	return this.playerImage;
    }

    public void setPosition(double x, double y){
        positionXGUI = x;
        positionYGUI = y;
    }
    
    public double getXPositionGUI() {
    	return this.positionXGUI;
    }

    public double getYPositionGUI() {
    	return this.positionYGUI;
    }





//    public boolean intersects(Sprite s)
//    {
//        return s.getBoundary().intersects( this.getBoundary() );
//    }

}