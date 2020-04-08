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

	private static Uwall[][] uw = new Uwall[8][8];
	private static Bwall[][] bw = new Bwall[8][8];

	public Map(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		makingMap();
	}

	public Map() {
		this.makingMap();
	}

	public void makingMap() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// player 1,player 2, bomb, breakable wall, un breakable wall,x,y,
				if (i == 0 & j == 0) {
					map[i][j] = new Tile();
					uw[i][j] = null;
					map[i][j].addGameObject(p1);
					map[i][j].setX(i);
					map[i][j].setY(j);

				} else if (i == 7 && j == 7) {
					uw[i][j] = null;
					map[i][j] = new Tile();
					map[i][j].addGameObject(p2);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 0 && j == 4) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 1 && j == 1) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);

				} else if (i == 2 && j == 3) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 2 && j == 5) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);

				} else if (i == 4 && j == 1) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 4 && j == 4) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 6 && j == 2) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 6 && j == 6) {

					Uwall uwl = new Uwall(j, i);
					uw[i][j] = uwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(uwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else if (i == 6 && j == 7) {
					Bwall bwl = new Bwall(j, i);
					bw[i][j] = bwl;
					map[i][j] = new Tile();
					map[i][j].addGameObject(bwl);
					map[i][j].setX(j);
					map[i][j].setY(i);
				} else {
					bw[i][j] = null;
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
		System.out.println("When in ");
		for (int i = 0; i < x.length; i++) {
			int tempx = x[i];
			for (int j = 0; j < y.length; j++) {
				int tempy = y[j];
				if (uw[tempy][tempx] == null) {
					if (map[tempy][tempx].isinTile(p1) || map[tempy][tempx].isinTile(p2)) {
						playerDown = true;
					}
					if (bw[tempy][tempx] != null) {
						bw[tempy][tempx] = null;
					}
					map[tempy][tempx].makeTileEmpty();
				}
			}
		}

		for (int i = 0; i < bw.length; i++) {
			for (int j = 0; j < bw[i].length; j++) {
				System.out.println(bw[i][j]);
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
				} else if (bw[i][j] != null) {
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

	public void makingMapForGui(GraphicsContext gc, Image imageUWall, Image imageBWall, Image imageMap) {
		// this.makingMap();
		double offSet = 62.5;
		double pixelXAxis = 0;
		double pixelYAxis = 0;
		gc.drawImage(imageMap, 0, 0);
		// MAKING UNBREAKABLE WALLS
		for (Uwall[] m : uw) {
			for (Uwall n : m) {
				if (n != null) {
					int g1 = n.getxCord();
					int g2 = n.getyCord();
					pixelXAxis = g1 * offSet;
					pixelYAxis = g2 * offSet;
					gc.drawImage(imageUWall, pixelXAxis, pixelYAxis);
				}
			}
		}
		

		// Making BREAKABLE WALLS
		for (int i = 0; i < bw.length; i++) {
			for (int j = 0; j < bw[i].length; j++) {
				if (bw[i][j] != null) {
					int g1 = bw[i][j].getxCord();
					int g2 = bw[i][j].getyCord();
					pixelXAxis = g1 * offSet;
					pixelYAxis = g2 * offSet;
					gc.drawImage(imageBWall, pixelXAxis, pixelYAxis);
				}
			}
		}

	}

}