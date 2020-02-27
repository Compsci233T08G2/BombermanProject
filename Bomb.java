public class Bomb extends Movement {

	public static void hit(Character player, int xBomb, int yBomb) {
		int tempX = xBomb;
		int tempY = yBomb;

		for (int i = -2; i <= 2; i++) {
			tempX = xBomb;
			tempX = xBomb + i;
			if (tempX >= 0 && tempX <= 10) {
				if (yBomb >= 0 && yBomb <= 10) {
					checkPlayerHit(tempX, yBomb, player);
					checkWallHit(tempX, yBomb);
				}
			}
		}
		for (int i = -2; i <= 2; i++) {
			tempY = yBomb;
			tempY = yBomb + i;
			if (tempX >= 0 && tempX <= 10) {
				if (tempY >= 0 && tempY <= 10) {
					
					if(!checkPlayerHit(xBomb, tempY, player)) {
						System.exit(0);
					}
					checkWallHit(xBomb, tempY);
				}
			}
		}
	}

	private static boolean checkPlayerHit(int xBomb2, int yBomb2, Character playerlol) {
		// TODO Auto-generated method stub
		if ((playerlol.x == xBomb2) && (playerlol.y == yBomb2)) {
			return true;
		} else {
			return false;
		}
	}

	private static void checkWallHit(int xBomb2, int yBomb2) {
		// TODO Auto-generated method stub
		System.out.print(xBomb2);
		System.out.print(yBomb2);
		System.out.println(" ");
		if (newMap.getMapxy(xBomb2, yBomb2) == 1) {
			newMap.setMapxy(xBomb2, yBomb2, 0);
			System.out.println("lol");
		}

	}
}
