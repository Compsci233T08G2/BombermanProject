package mechanics;

import java.util.Scanner;

public class TextBased {

	private static Player p1;
	private static Player p2;

	private static boolean playerAlive = true;
	private static String movement;
	private static boolean whichp = true; // true for p1 and false for p2

	public static void main(String[] args) {

		// intiallizing variables
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of player one: ");
		p1 = new Player(0, 0, sc.nextLine());
		System.out.println("Name of player two: ");
		p2 = new Player(7, 7, sc.nextLine());
		GameObject.intializingMap(p1, p2);
		// Calling Game play Method
		play();

	}

	public static void play() {
		// TODO Auto-generated method stub
		while (playerAlive) {
			player1();
			player2();
		}
		System.out.println("Game Over");

	}

	public static void player2() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean checking = true;
		while (checking) {
			System.out.println("Player two which direction will you like to move (down/up/right/left/none/bomb)");
			movement = sc.nextLine();
			if (movement.equalsIgnoreCase("bomb")) {
				bomb(p2.getxCord(), p2.getyCord());
				checking = false;
			} else {
				if (!p2.move(movement, p2)) {
					System.out.println("Unfortunatly you moved in an invalid direction");
					System.out.println("PLEASE TRY AGAIN");
				} else {
					checking = false;
				}
			}
		}

	}

	public static void player1() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean checking = true;
		while (checking) {
			System.out.println("Player one which direction will you like to move (down/up/right/left/none/bomb)");
			movement = sc.nextLine();
			if (movement.equalsIgnoreCase("bomb")) {
				bomb(p1.getxCord(), p1.getyCord());
				checking = false;
			} else {

				if (!p1.move(movement, p1)) {
					System.out.println("Unfortunatly you moved in an invalid direction");
					System.out.println("PLEASE TRY AGAIN");
				} else {
					checking = false;
				}
			}
		}

	}

	public static void bomb(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(
				"Because this is a text based game there will ONLY 5 movements AND IN THIS VERSION ONCE A PEERSON THROWS A BOMB NO ONE ELSE CAN THROW A BOMB DURING THOSE 5 STEPS");
		Bomb bomb = new Bomb(x, y);
		for (int i = 0; i < 5; i++) {
			player1Bomb();
			player2Bomb();

		}
		boolean cat = bomb.Blown();
		if (cat) {
			playerAlive = false;
		} else {
			playerAlive = true;
		}

	}

	public static void player2Bomb() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean checking = true;
		while (checking) {
			System.out.println("Player two which direction will you like to move (down/up/right/left/none)");
			movement = sc.nextLine();
			if (!p2.move(movement, p2)) {
				System.out.println("Unfortunatly you moved in an invalid direction");
				System.out.println("PLEASE TRY AGAIN");
			} else {
				checking = false;
			}
		}
	}

	public static void player1Bomb() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean checking = true;
		while (checking) {
			System.out.println("Player one which direction will you like to move (down/up/right/left/none)");
			movement = sc.nextLine();
			if (!p1.move(movement, p1)) {
				System.out.println("Unfortunatly you moved in an invalid direction");
				System.out.println("PLEASE TRY AGAIN");
			} else {
				checking = false;
			}
		}
	}

}
