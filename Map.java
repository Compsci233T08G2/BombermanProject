public class Map {
	private int x;
	private int y;
	private int[][] map = { { 3, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0 }, { 0, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1 },
			{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, { 0, 2, 1, 2, 0, 2, 0, 2, 1, 2, 0 },
			{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0 },
			{ 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 4 }, };

	public int[][] getMap() {
		return map.clone();
	}

	public int getMapxy(int x, int y) {
		return map[x][y];
	}

	public void setMapxy(int x, int y, int ne) {
		map[x][y] = ne;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}
	public void print() {
		for(int i = 0; i <11; i++) {
			for(int j=0;j<11;j++) {
				System.out.print(String.format("%20s", map[i][j]));
			}
			System.out.println(" ");
		}
	}

	public boolean checkWallmovement() {
		if (map[x][y] == 2) {
			return false;
		} else if (map[x][y] == 1) {
			return false;
		} else
			return true;
	}
}