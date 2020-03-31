package mechanics;

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
	public boolean move(String direction, GameObject o) {

		int tempx = o.getxCord();
		int tempy = o.getyCord();
		if (direction.equalsIgnoreCase("up")) {
			tempy--;
			if (tempy >= 0 && tempy < map.getLength()) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (direction.equalsIgnoreCase("down")) {
			tempy++;
			System.out.println(tempx);
			System.out.println(tempy);
			if (tempy >= 0 && tempy < map.getLength()) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (direction.equalsIgnoreCase("right")) {
			tempx++;
			if (tempy >= 0 && tempy < map.getLength()) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (direction.equalsIgnoreCase("left")) {
			tempy--;
			if (tempy >= 0 && tempy < map.getLength()) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (direction.equalsIgnoreCase("none")) {
			return true;
		} else {
			return false;
		}

	}
}
