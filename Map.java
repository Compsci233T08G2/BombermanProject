package mechanics;

import java.util.Arrays;

public class Map {

	private Tile[][] map = new Tile[8][8];
	private Player p1;
	private Bomb b;
	private Player p2;
	private Bwall bw;
	private Uwall uw;

	public Map(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		makingMap();
	}

	public void makingMap() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// player 1,player 2, bomb, breakable wall, un breakable wall,x,y,
				if (i == 0 & j == 0) {
					map[i][j] = new Tile();
					map[i][j].addGameObject(p1);
					map[i][j].setX(i);
					map[i][j].setY(j);

				} else if (i == 7 && j == 7) {
					map[i][j] = new Tile();
					map[i][j].addGameObject(p2);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else if (i == 4 && j == 0) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else if (i == 1 && j == 1) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);

				} else if (i == 3 && j == 2) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else if (i == 5 && j == 2) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
					;
				} else if (i == 1 && j == 4) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else if (i == 4 && j == 4) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else if (i == 2 && j == 6) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else if (i == 6 && j == 6) {
					Uwall uw = new Uwall(i, j);
					map[i][j] = new Tile();
					map[i][j].addGameObject(uw);
					map[i][j].setX(i);
					map[i][j].setY(j);
				} else {
					map[i][j] = new Tile();
					map[i][j].setX(i);
					map[i][j].setY(j);
				}
			}
		}
	}

	public boolean isMove(int x, int y) {
		if (map[x][y].emptyTile()) {
			return true;
		} else {

			return false;
		}

	}

	public void moving(int x, int y, int mx, int my, GameObject o) {
		if (map[x][y].isinTile(o)) {
			map[x][y].removeGameObject(o);
			map[mx][my].addGameObject(o);
			o.setxCord(mx);
			o.setyCord(my);
		}
	}

	public boolean blowingUp(int[] x, int[] y) {
		boolean playerDown = false;
		for (int i = 0; i < x.length; i++) {
			int tempx = x[i];
			for (int j = 0; j < y.length; j++) {
				int tempy = y[j];
				if (!map[tempx][tempy].isinTile(bw)) {
					if (map[tempx][tempy].isinTile(p1) || map[tempx][tempy].isinTile(p2)) {
						playerDown = true;
					}
					map[tempx][tempy].makeTileEmpty();
				}
			}
		}
		return playerDown;

	}

	public int getLength() {
		// TODO Auto-generated method stub
		return map.length;
	}

}