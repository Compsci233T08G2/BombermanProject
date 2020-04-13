package mechanics;

/*
 * this class is responsible for making the player as well as its movement 
 */

public class Player extends GameObject {

	private String Playerid;

//Constructors
	/*
	 * this constructor takes in the x and y coordinates of the player along side
	 * the name
	 */
	public Player(int xCoord, int yCoord, String Playerid) {
		super(xCoord, yCoord);
		this.Playerid = Playerid;
	}

	/*
	 * this method returns the players name
	 */
	public String getPlayerid() {
		return Playerid;
	}

	/*
	 * this method takes in a string and sets it equal to the name
	 */
	public void setPlayerid(String Playerid) {
		this.Playerid = Playerid;
	}

//// in Player.java class
	/*
	 * this method takes in a string which is either up,down,right,left,none and an
	 * object. this method first checks if the object can move in that direction by
	 * calling methods in the map class and if the object can move there it moves
	 * the object and prints the map and returns true if the player can not move in
	 * that direction the method returns false
	 */
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
