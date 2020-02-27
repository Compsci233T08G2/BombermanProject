public class Bomb extends Movement {

	public static void hit(Character player, int xBomb, int yBomb) {
		//Bomb location is equal to a temporary variable which will be changed below to 
		//check around the bomb
		int tempX = xBomb;
		int tempY = yBomb;
		
		//this for loop checks x coordinates in every direction of the bomb for a radius 2
		for (int i = -2; i <= 2; i++) {
			tempX = xBomb;
			tempX = xBomb + i;
			if (tempX >= 0 && tempX <= 10) {
				if (yBomb >= 0 && yBomb <= 10) {
					checkPlayerHit(tempX, yBomb, player);
					if(!checkPlayerHit(xBomb, tempY, player)) {
						System.out.println("THE END");
						System.exit(0);
					}
					checkWallHit(tempX, yBomb);
				}
			}
		}
		//this for loop checks x coordinates in every direction of the bomb for a radius 2
		for (int i = -2; i <= 2; i++) {
			tempY = yBomb;
			tempY = yBomb + i;
			if (xBomb >= 0 && xBomb <= 10) {
				if (tempY >= 0 && tempY <= 10) {
					
					if(!checkPlayerHit(xBomb, tempY, player)) {
						System.out.println("THE END");
						System.exit(0);
					}
					checkWallHit(xBomb, tempY);
				}
			}
		}
	}
	//this method checks if the player is hit and returns true or false
	private static boolean checkPlayerHit(int xBomb2, int yBomb2, Character playerlol) {
		// TODO Auto-generated method stub
		if ((playerlol.x == xBomb2) && (playerlol.y == yBomb2)) {
			return true;
		} else {
			return false;
		}
	}
	//checks if a breakable wall is hit and changes that to a movebal area 
	private static void checkWallHit(int xBomb2, int yBomb2) {
		// TODO Auto-generated method stub
		if (newMap.getMapxy(xBomb2, yBomb2) == 1) {
			newMap.setMapxy(xBomb2, yBomb2, 0);
		}

	}
}
