package mechanics;

import java.util.ArrayList;

public class Tile {

	private ArrayList<GameObject> gameObjects;
	private int x; // x-index in the map
	private int y; // y-index in the map

	public Tile() {
		gameObjects = new ArrayList<GameObject>();
	}

	public void addGameObject(GameObject o) {
		gameObjects.add(o);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void removeGameObject(GameObject o) {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i) == o) {
				gameObjects.remove(o);
			}
		}

	}

	public boolean isinTile(GameObject o) {
		boolean inTile = false;
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i) == o) {
				inTile = true;
			}
		}
		return inTile;
	}

	public boolean emptyTile() {
		return gameObjects.isEmpty();
	}

	public void makeTileEmpty() {
		gameObjects.clear();
	}

	public void print() {
		System.out.println(gameObjects);
	}
}