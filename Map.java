
package mechanics;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/*
 * The following class contains methods which are used to make and manipulate the map 
 */

public class Map {

	private Tile[][] map = new Tile[8][8];
	private Player p1;
	private Bomb b;
	private Player p2;

	private Uwall[][] uw = new Uwall[8][8];
	private static Bwall[][] bw = new Bwall[8][8];

	/*
	 * this constructor takes in player one and two as arugments and makes the map
	 * using those players
	 */
	public Map(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		makingMap();
	}

	/*
	 * this constructor is like a default constructor when called it just
	 * intiallizes the map
	 */
	public Map() {

		makingMap();
	}

	/*
	 * The following method has a double for loop which fills the "MAP" with objects
	 * based off of there coordinates
	 */
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

	/*
	 * this method takes in an x and y coordinate and checks if the tile at that
	 * location in the map is empty and returns true if it is and false if not
	 */
	public boolean isMove(int x, int y) {
		if (map[y][x].emptyTile()) {
			return true;
		} else {

			return false;
		}

	}

	/*
	 * The following method takes in the objects current x and y coordinates and the
	 * coordinates the object would like to move to as mx and my and the object that
	 * would like to move. The method intially checks if the object is in the tile
	 * and if soe moves the object from its intial location to its desired location
	 * and changes its x and y coordinates
	 */
	public void moving(int x, int y, int mx, int my, GameObject o) {
		if (map[y][x].isinTile(o)) {
			map[y][x].removeGameObject(o);
			map[my][mx].addGameObject(o);
			o.setxCord(mx);
			o.setyCord(my);
		}
	}

	/*
	 * The following method takes in two arrays x and y which hold coordinates of
	 * where the bomb blows and the method goes through the map and checks each tile
	 * to see if it contains something which can blow up and removes it from the map
	 * and if there is a player in that region it removes the player it returns true
	 * if the player was not in the region returns false returns false
	 */
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
					if (bw[tempy][tempx] != null) {
						bw[tempy][tempx] = null;
					}
					map[tempy][tempx].makeTileEmpty();
				}
			}
		}
		printMap();
		return playerDown;

	}

	/*
	 * Returns the length of the map array
	 */
	public int getLength() {
		// TODO Auto-generated method stub
		return map.length;
	}

	/*
	 * The Following method loops through the double array map and prints the
	 * objects inside the array such as the bomb, walls,etc.
	 */
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
					System.out.print("L");
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
				if (uw[i][j] != null) {
					pixelXAxis = j * offSet;
					pixelYAxis = i * offSet;
					gc.drawImage(imageUWall, pixelXAxis, pixelYAxis);
				}
			}
		}

	}

}