package mechanics;

public class Bomb extends GameObject {
	int[] xValues = new int[4];
	int[] yValues = new int[4];

	public Bomb(int xCord, int yCord) {
		super(xCord, yCord);
		// TODO Auto-generated constructor stub
	}

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

	public int[] getX() {
		return xValues;
	}

	public int[] getY() {
		return yValues;

	}

}
