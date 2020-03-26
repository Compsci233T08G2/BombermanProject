public class Wall extends GameObject {

	private int xCord;
	private int yCord;

	public Wall(int xCord, int yCord) {
		super(xCord, yCord);
		this.xCord = xCord;
		this.yCord = yCord;
	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

}