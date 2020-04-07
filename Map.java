package mechanics;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {

	private Tile[][] map = new Tile[8][8];
	private Player p1;
	private Bomb b;
	private Player p2;
	private Bwall bw;
	private ArrayList<ArrayList<Integer>> guiMap = new ArrayList<ArrayList<Integer>>();

	private Uwall[][] uw = new Uwall[8][8];

	public Map(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		makingMap();
	}

	public Map() {

	}

	public void makingMap() {
		ArrayList<Integer> infoForGuiMap = new ArrayList<Integer>();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// player 1,player 2, bomb, breakable wall, un breakable wall,x,y,
				if (i == 0 & j == 0) {
					map[i][j] = new Tile();
					uw[i][j] = null;
					map[i][j].addGameObject(p1);
					map[i][j].setX(i);
					map[i][j].setY(j);

				} /*
					 * else if (i == 7 && j == 7) { uw[i][j] = null; map[i][j] = new Tile();
					 * map[i][j].addGameObject(p2); map[i][j].setX(j); map[i][j].setY(i); }
					 */ else if (i == 0 && j == 4) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 1 && j == 1) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);

				} else if (i == 2 && j == 3) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 2 && j == 5) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);

				} else if (i == 4 && j == 1) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 4 && j == 4) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 6 && j == 2) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 6 && j == 6) {
					infoForGuiMap.add(j);
					infoForGuiMap.add(i);
					guiMap.add(new ArrayList<Integer>(infoForGuiMap));
					infoForGuiMap.clear();

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else {
					uw[i][j] = null;
					map[i][j] = new Tile();
					map[i][j].setX(j);
					map[i][j].setY(i);
				}
			}
		}
	}

	public boolean isMove(int x, int y) {
		if (map[y][x].emptyTile()) {
			return true;
		} else {

			return false;
		}

	}

	public void moving(int x, int y, int mx, int my, GameObject o) {
		if (map[y][x].isinTile(o)) {
			map[y][x].removeGameObject(o);
			map[my][mx].addGameObject(o);
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
				if (uw[tempy][tempx] == null) {
					if (map[tempy][tempx].isinTile(p1) || map[tempy][tempx].isinTile(p2)) {
						playerDown = true;
					}
					map[tempy][tempx].makeTileEmpty();
				}
			}
		}
		return playerDown;

	}

	public int getLength() {
		// TODO Auto-generated method stub
		return map.length;
	}

	public void printMap() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j].emptyTile()) {
					System.out.print("-");
					System.out.print(" ");
				} else if (uw[i][j] != null) {
					System.out.print("X");
					System.out.print(" ");
				} else if (map[i][j].isinTile(bw)) {
					System.out.print("B");
					System.out.print(" ");
				} else if (map[i][j].isinTile(p1)) {
					System.out.print(p1.getPlayerid());
					System.out.print(" ");
				} else if (map[i][j].isinTile(p2)) {
					System.out.print(p2.getPlayerid());
					System.out.print(" ");
				} else if (map[i][j].isinTile(b)) {
					System.out.print("B");
					System.out.print(" ");
				} else {
					System.out.print("?");
					System.out.print(" ");
				}
			}
			System.out.println("");
		}

	}

	public void makingMapForGui(GraphicsContext gc, Image imageWall, Image imageMap) {
		guiMap.clear();
		this.makingMap();
		double offSet = 62.5;
		double pixelXAxis = 0;
		double pixelYAxis = 0;
		gc.drawImage(imageMap, 0, 0);
		for (ArrayList<Integer> m : guiMap) {
			int g1 = m.get(0);
			pixelXAxis = g1 * offSet;
			int g2 = m.get(1);
			pixelYAxis = g2 * offSet;
			gc.drawImage(imageWall, pixelXAxis, pixelYAxis);
		}
	}

}