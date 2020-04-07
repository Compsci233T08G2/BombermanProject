import javafx.scene.image.Image;
import mechanics.*;
import mechanics.Map;
import javafx.scene.canvas.GraphicsContext;




////////////////////////////////////////////////////
public class guiPlayer extends Player{
    private Image playerImage;
    private double positionXOnMap;
    private double positionYOnMap;


    public guiPlayer(int positionX, int positionY,String playerId) {
    	super(positionX,positionY,playerId);
        this.positionXOnMap = positionX;
        this.positionYOnMap = positionY;
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
        positionXOnMap = x;
        positionYOnMap = y;
    }
    public double getXPosition() {
    	return this.positionXOnMap;
    }

    public double getYPosition() {
    	return this.positionYOnMap;
    }





//    public boolean intersects(Sprite s)
//    {
//        return s.getBoundary().intersects( this.getBoundary() );
//    }

}