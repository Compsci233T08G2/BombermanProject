import javafx.scene.image.Image;
import mechanics.Bomb;

public class guiBomb{
	private Image bombImage;
	private double xcoord;
	private double ycoord;
	public guiBomb(double xCord, double yCord) {
		//super(xCord, yCord);
		xcoord=xCord;
		ycoord=yCord;
		bombImage = new Image("BombermanBomb.png");
	}
	public double getXcoord() {
		return xcoord;
	}
	public double getYcoord() {
		return ycoord;
	}
	public void setXcoord(double xcoord) {
		this.xcoord = xcoord;
	}
	public void setYcoord(double ycoord) {
		this.ycoord = ycoord;
	}
	public Image getBombImage() {
		return bombImage;
	}
	public void setBombImage(Image bombImage) {
		this.bombImage = bombImage;
	}
	
//	public double getXForMap() {
//		return super.getxCord()*62.5;			
//	}
//	public double getYForMap() {
//		return super.getyCord()*62.5;			
//	}
}
