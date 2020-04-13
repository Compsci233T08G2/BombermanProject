package textBased;

import java.util.Scanner;

import mechanics.Bomb;
import mechanics.GameObject;
import mechanics.Map;
import mechanics.Player;

public class TextBased {

	public static void main(String[] args) {

		// intiallizing variables and map
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of player one: ");
		Player p1 = new Player(0, 0, sc.nextLine());
		System.out.println("Name of player two: ");
		Player p2 = new Player(7, 7, sc.nextLine());
		GameObject.intializingMap(p1, p2);
		// calls text game with variables
		TextGame l = new TextGame(p1, p2);

	}

}
