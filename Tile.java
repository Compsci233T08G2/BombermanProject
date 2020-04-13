package mechanics;

import java.util.ArrayList;

public class Tile {

	private ArrayList<GameObject> gameObjects;
	private int x; // x-index in the map
	private int y; // y-index in the map

	/*
	 * when a new tile is made this constructor initializes the arraylist
	 */
	public Tile() {
		gameObjects = new ArrayList<GameObject>();
	}

	/*
	 * method takes in an object as an argument and addd tis to the arraylist of
	 * game objects
	 */
	public void addGameObject(GameObject o) {
		gameObjects.add(o);
	}

	/*
	 * gets the x coordinate of the tile
	 */
	public int getX() {
		return x;
	}

	/*
	 * sets the x coordinate of the tile
	 */
	public void setX(int x) {
		this.x = x;
	}

	/*
	 * gets the y coordinate of the tile
	 */
	public int getY() {
		return y;
	}

	/*
	 * sets the y coordinate of the tile
	 */
	public void setY(int y) {
		this.y = y;
	}

	/*
	 * takes a game object as an argument and removes that game object from the
	 * arraylist of game objects
	 */
	public void removeGameObject(GameObject o) {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i) == o) {
				gameObjects.remove(o);
			}
		}

	}

	/*
	 * Takes in a gameobject and returns true or false if the object is in the array
	 * list
	 */
	public boolean isinTile(GameObject o) {
		boolean inTile = false;
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i) == o) {
				inTile = true;
			}
		}
		return inTile;
	}

	/*
	 * returns true if the arraylist is empty and false if the array list is not
	 * empty
	 */
	public boolean emptyTile() {
		return gameObjects.isEmpty();
	}

	/*
	 * this method makes the arraylist empty
	 */
	public void makeTileEmpty() {
		gameObjects.clear();
	}

	/*
	 * this method prints the arraylist
	 */
	public void print() {
		System.out.println(gameObjects);
	}
}