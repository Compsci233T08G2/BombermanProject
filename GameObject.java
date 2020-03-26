public class GameObject {
	protected Map map = new Map();
	private int xCord;
	private int yCord;

	public GameObject(int xCord, int yCord) {
		if (xCord >= 0 && xCord <= map.getLength()) {
			this.xCord = xCord;
		}
		if (yCord >= 0 && xCord <= map.getLength()) {
			this.yCord = yCord;
		}

	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		if (xCord >= 0 && xCord <= map.getLength()) {
			this.xCord = xCord;
		}
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		if (yCord >= 0 && yCord <= map.getLength()) {
			this.yCord = yCord;
		}
	}

	public void intializingMap() {
		map.makingMap();
	}

}
