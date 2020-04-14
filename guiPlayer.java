package graphics;
import javafx.scene.image.Image;
import mechanics.*;
import mechanics.Map;
import javafx.scene.canvas.GraphicsContext;




////////////////////////////////////////////////////
/*
 * This class extends the "player" class from the logic(mechanics class).
 */
public class guiPlayer extends Player{
	private Image playerImage;
    private double positionXGUI;
    private double positionYGUI;
    private double offSet=62.5;//Pixel size of the tile in the GUIMAP.

    //CONSTRUCTOR
    public guiPlayer(int positionX, int positionY,String playerId,Image image) {
    	super(positionX,positionY,playerId);
        this.positionXGUI = positionX*offSet;
        this.positionYGUI = positionY*offSet;
        this.playerImage = image;

    }
    
    
    public void setImage(Image sprite){
        playerImage = sprite;
    }
    // SETS IMAGES FROM A PATH.
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



}