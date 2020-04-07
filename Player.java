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
		System.out.println("");
		map.printMap();
		System.out.println("");
		System.out.println("AFTER MOVE");
		System.out.println("");
		int tempx = o.getxCord();
		int tempy = o.getyCord();
		if (direction.equalsIgnoreCase("up")) {
			tempy--;
			if (tempy >= 0 && tempy <= map.getLength() - 1) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					map.printMap();
					return true;
				} else {
					map.printMap();
					return false;
				}
			} else {
				map.printMap();
				return false;
			}
		} else if (direction.equalsIgnoreCase("down")) {
			tempy++;
			if (tempy >= 0 && tempy <= map.getLength() - 1) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					map.printMap();
					return true;
				} else {
					map.printMap();
					return false;
				}
			} else {
				map.printMap();
				return false;
			}
		} else if (direction.equalsIgnoreCase("right")) {
			tempx++;
			if (tempx >= 0 && tempx <= map.getLength() - 1) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					map.printMap();
					return true;
				} else {
					map.printMap();
					return false;
				}
			} else {
				map.printMap();
				return false;
			}
		} else if (direction.equalsIgnoreCase("left")) {
			tempx--;
			if (tempx >= 0 && tempx <= map.getLength() - 1) {
				if (map.isMove(tempx, tempy)) {
					map.moving(o.getxCord(), o.getyCord(), tempx, tempy, o);
					map.printMap();
					return true;
				} else {
					map.printMap();
					return false;
				}
			} else {
				map.printMap();
				return false;
			}
		} else if (direction.equalsIgnoreCase("none")) {
			map.printMap();
			return true;
		} else {
			map.printMap();
			return false;
		}

	}
}
