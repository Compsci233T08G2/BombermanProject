
public class Character {
	String playerID;
	//Position playerPosition;
	int x;
	int y;
	public void setPlayerPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String getName() {
		return this.playerID;
	}
	public void setName(String playerID) {
		this.playerID = playerID;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public Character(String playerID, int x, int y) {
		this.playerID = playerID;
		this.x = x;
		this.y = y;
	}
	public Character(Character character) {
		playerID = character.playerID;
		x = character.x;
		y = character.y;
	}
	/*public void moveUp(int x) {
		this.x = x;
		this.y = y;
	}*/
	/*public Character(String playerID, Position playerPosition) {
		this.playerID = playerID;
		this.playerPosition = playerPosition;
	}*/
	
	/*public boolean isHit(Position playerPosition, Position bombPosition) {
		if (playerPosition.equals(bombPosition)) {
			return true;
		}
		return false;*/
	}

