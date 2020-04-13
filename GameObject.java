package mechanics;

public abstract class GameObject {
	protected static Map map;
	private int xCord;
	private int yCord;

	public GameObject(int xCord, int yCord) {
		if (xCord >= 0 && xCord <= 8) {
			this.xCord = xCord;
		}
		if (yCord >= 0 && yCord <= 8) {
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

	public static void intializingMap(Player p1, Player p2) {
		map = new Map(p1, p2);
		map.printMap();

	}

}
