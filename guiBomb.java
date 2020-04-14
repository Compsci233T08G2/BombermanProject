package graphics;
import javafx.scene.image.Image;
import mechanics.Bomb;

public class guiBomb extends Bomb{
	
	private Image bombImage;
	private double xcoordGUI;
	private double ycoordGUI;
	//BOMBFLAG IS SET TRUE WHEN THE BOMB IS ON THE MAP
	private boolean bombFlag;
	
	//COMSTRUCTOR
	public guiBomb(int xCord, int yCord,double xcoordGUI, double ycoordGUI) {
		super(xCord, yCord);
		this.xcoordGUI = xcoordGUI;
		this.ycoordGUI = ycoordGUI;
		bombImage = new Image("BombermanBomb.png");
		bombFlag=false;		
	}
	//GETTERS AND SETTERS.
	public double getXcoord() {
		return xcoordGUI;
	}
	public double getYcoord() {
		return ycoordGUI;
	}
	public void setXcoord(double xcoord) {
		this.xcoordGUI = xcoord;
	}
	public void setYcoord(double ycoord) {
		this.ycoordGUI = ycoord;
	}
	public Image getBombImage() {
		return bombImage;
	}
	public void setBombImage(Image bombImage) {
		this.bombImage = bombImage;
	}
	
	public void setBombFlag(boolean state) {
		bombFlag=state;
	}
	public boolean getBombFlag() {
		return bombFlag;
	}
	

}
