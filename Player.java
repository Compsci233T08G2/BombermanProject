public class Player extends GameObject {

	private String Playerid;

//Constructors
	public Player(int xCoord, int yCoord, String Playerid) {
		super(xCoord, yCoord);
		this.Playerid = Playerid;
	}

	public String getPlayerid() {
		return Playerid;
	}

	public void setPlayerid(String Playerid) {
		this.Playerid = Playerid;
	}

//// in Player.java class
	public boolean move(int x, int y, String direction, GameObject o) {
		int tempy = y;
		int tempx = x;
		if (direction.equals("up")) {
			tempy--;
			if (tempy > 0) {
				if (map.isMove(tempx, tempy)) {
					map.moving(x, y, tempx, tempy, o);
					return true;
				}
			} else {
				return false;
			}
		} else if (direction.equals("down")) {
			tempy++;
			if (tempy > 0) {
				if (map.isMove(tempx, tempy)) {
					map.moving(x, y, tempx, tempy, o);
					return true;
				}
			} else {
				return false;
			}
		} else if (direction.equals("right")) {
			tempx++;
			if (tempx > 0) {
				if (map.isMove(tempx, tempy)) {
					map.moving(x, y, tempx, tempy, o);
					return true;
				}
			} else {
				return false;
			}
		} else {
			tempx--;
			if (tempx > 0) {
				if (map.isMove(tempx, tempy)) {
					map.moving(x, y, tempx, tempy, o);
					return true;
				}
			} else {
				return false;
			}
		}
		return true;

	}
}
