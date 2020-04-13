package mechanics;

/*
 * this class creates a bomb and has a bomb method which blows the bomb up 
 */
public class Bomb extends GameObject {
	int[] xValues = new int[4];
	int[] yValues = new int[4];

	/*
	 * this constructor takes in the x coord and y coord of the bomb
	 */
	public Bomb(int xCord, int yCord) {
		super(xCord, yCord);
		// TODO Auto-generated constructor stub
	}

	/*
	 * this method returns true and false true if the player dies and false if the
	 * player is alive. it intially makes an array of x and y coordinates of the
	 * bomb blown radius and checks using a method in the map class to see if the
	 * player dies and also removes objects in that radius.
	 */
	public Boolean Blown() {
		int tempx = super.getxCord();
		int tempy = super.getyCord();

		tempx = super.getxCord() + 1;
		tempy = super.getyCord();
		if (tempx >= 0 && tempx <= map.getLength() - 1) {
			xValues[0] = tempx;
			yValues[0] = tempy;
		} else {
			xValues[0] = super.getxCord();
			yValues[0] = super.getyCord();
		}

		tempx = super.getxCord() - 1;
		tempy = super.getyCord();
		if (tempx >= 0 && tempx <= map.getLength() - 1) {
			xValues[1] = tempx;
			yValues[1] = tempy;
		} else {
			xValues[1] = super.getxCord();
			yValues[1] = super.getyCord();
		}

		tempx = super.getxCord();
		tempy = super.getyCord() + 1;
		if (tempy >= 0 && tempy <= map.getLength() - 1) {
			xValues[2] = tempx;
			yValues[2] = tempy;
		} else {
			xValues[2] = super.getxCord();
			yValues[2] = super.getyCord();
		}

		tempx = super.getxCord();
		tempy = super.getyCord() - 1;
		if (tempy >= 0 && tempy <= map.getLength() - 1) {
			xValues[3] = tempx;
			yValues[3] = tempy;
		} else {
			xValues[3] = super.getxCord();
			yValues[3] = super.getyCord();
		}
		return (map.blowingUp(xValues, yValues));
	}

	/*
	 * returns the x coord of the bomb radius
	 */
	public int[] getX() {
		return xValues;
	}

	/*
	 * returns the y coord of the bomb radius
	 */
	public int[] getY() {
		return yValues;

	}

}