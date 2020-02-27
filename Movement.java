import java.util.Scanner;

public class Movement {

	//this variable holds whether the players are alive are not
	private static boolean playerOneAlive = true;
	private static boolean playerTwoAlive = true;

	//new player is made on either side of the map
	protected static Character player1 = new Character("lol", 0, 0);
	private static Character player2 = new Character("lolz", 10, 10);

	//holds where they wanna move 
	private static String move1;
	private static String move2;
	
	//temporary variable to check if there is valid movement 
	private static int tempx;
	private static int tempy;
	
	//creates a new variable
	protected static Map newMap = new Map();
	
	//booleans to check if allowed to move and if bomb is placed 
	private static boolean checking = false;
	private static boolean bombPlaced = false;

	public static void main(String[] args) {
		movement();
		newMap.print();
	}

	//this method gets which way the person wants to move and calls update to make sure its valid and move if it is or 
	//returns false so the method is recalled
	public static void movement() {
		Scanner sc = new Scanner(System.in);
		checking = false;
		while (playerOneAlive && playerTwoAlive) {
			while (!checking) {
				System.out.println("Player One");
				System.out.println("Would you like to move right(R),left(L),up(U),down(D),none(N),bomb(B)");
				newMap.print();
				move1 = sc.nextLine();
				checking = update(move1, player1.x, player1.y, 1);

				if (bombPlaced) {
					for (int i = 0; i < 5; i++) {
						while (!checking) {
							System.out.println("Player One");
							System.out.println("Would you like to move right(R),left(L),up(U),down(D),none(N),bomb(B)");
							newMap.print();
							move1 = sc.nextLine();
							checking = update(move1, player1.x, player1.y, 1);
						}
						checking = false;
						while (!checking) {
							System.out.println("Player Two");
							System.out.println("Would you like to move right(R),left(L),up(U),down(D),none(N),bomb(B)");
							newMap.print();
							move2 = sc.nextLine();
							checking = update(move2, player2.x, player2.y, 2);
						}
						checking = false;
						System.out.println(i + "number of movements till bomb goes off");
					}
					bombPlaced = false;
					Bomb.hit(player1, player1.x, player1.y);

				}
			}
			checking = false;
			while (!checking) {
				System.out.println("Player Two");
				System.out.println("Would you like to move right(R),left(L),up(U),down(D),none(N),bomb(B)");
				newMap.print();
				move2 = sc.nextLine();

				checking = update(move2, player2.x, player2.y, 2);
				if (bombPlaced) {
					for (int i = 0; i < 5; i++) {
						while (!checking) {
							System.out.println("Player One");
							System.out.println("Would you like to move right(R),left(L),up(U),down(D),none(N),bomb(B)");
							newMap.print();
							move1 = sc.nextLine();
							checking = update(move1, player1.x, player1.y, 1);
						}
						checking = false;
						while (!checking) {
							System.out.println("Player Two");
							System.out.println("Would you like to move right(R),left(L),up(U),down(D),none(N),bomb(B)");
							newMap.print();
							move2 = sc.nextLine();
							checking = update(move2, player2.x, player2.y, 2);
						}
						checking = false;
						System.out.println(i + "number of movements till bomb goes off");
					}
					bombPlaced = false;

					Bomb.hit(player2, player2.x, player2.y);
				}
			}
			checking = false;
		}
	}
	
	//checks if the movement is valid and moves the player if it is 
	
	public static boolean update(String move, int tempx1, int tempy1, int whichPlayer) {
		tempx = tempx1;
		tempy = tempy1;
		if (move.equalsIgnoreCase("r")) {
			tempx++;
			if (tempx < 0 || tempx > 10) {
				System.out.println("You are out of the bounds can't move to the right");
				return false;
			} else if (newMap.getMapxy(tempx, tempy) != 0) {
				System.out.println("There is a Wall there can't move to the right");
				return false;
			} else {
				if (whichPlayer == 1) {
					newMap.setMapxy(player1.x, player1.y, 0);
					player1.x = tempx;
					System.out.println(player1.y);
					newMap.setMapxy(player1.x, player1.y, 3);
				} else {
					newMap.setMapxy(player2.x, player2.y, 0);
					player2.x = tempx;
					newMap.setMapxy(player2.x, player2.y, 4);
				}
				return true;
			}
		}

		else if (move.equalsIgnoreCase("l")) {
			tempx--;
			if (tempx < 0 || tempx > 10) {
				System.out.println("You are out of the bounds can't move to the left");
				return false;
			} else if (newMap.getMapxy(tempx, tempy) != 0) {
				System.out.println("There is a Wall there can't move to the left");
				return false;
			} else {
				if (whichPlayer == 1) {
					newMap.setMapxy(player1.x, player1.y, 0);
					player1.x = tempx;
					newMap.setMapxy(player1.x, player1.y, 3);
				} else {
					newMap.setMapxy(player2.x, player2.y, 0);
					player2.x = tempx;
					newMap.setMapxy(player2.x, player2.y, 4);
				}
				return true;
			}
		}

		else if (move.equalsIgnoreCase("u")) {
			tempy--;
			if (tempy < 0 || tempy > 10) {
				System.out.println("You are out of the bounds can't move up");
				return false;
			} else if (newMap.getMapxy(tempx, tempy) != 0) {
				System.out.println("There is a Wall there can't move up");
				return false;
			} else {
				if (whichPlayer == 1) {
					newMap.setMapxy(player1.x, player1.y, 0);
					player1.y = tempy;
					newMap.setMapxy(player1.x, player1.y, 3);
				} else {
					newMap.setMapxy(player2.x, player2.y, 0);
					player2.y = tempy;
					newMap.setMapxy(player2.x, player2.y, 4);
				}
				return true;
			}
		} else if (move.equalsIgnoreCase("d")) {
			tempy++;
			if (tempy < 0 || tempy > 10) {
				System.out.println("You are out of the bounds can't move down");
				return false;
			} else if (newMap.getMapxy(tempx, tempy) != 0) {
				System.out.println("There is a Wall there can't move down");
				return false;
			} else {
				if (whichPlayer == 1) {
					newMap.setMapxy(player1.x, player1.y, 0);
					player1.y = tempy;
					newMap.setMapxy(player1.x, player1.y, 3);
				} else {
					newMap.setMapxy(player2.x, player2.y, 0);
					player2.y = tempy;
					newMap.setMapxy(player2.x, player2.y, 4);
				}
				return true;
			}

		}

		else if (move.equalsIgnoreCase("b")) {
			if (bombPlaced) {
				System.out.println("wait Till first bomb blows up");
				return false;
			} else {
				System.out.println("Only Allowed 5 Steps Movement");
				bombPlaced = true;
				return true;
			}
		}

		else if (move.equalsIgnoreCase("n")) {
			return true;
		}

		else {
			return false;
		}

	}

	public static void end() {
		System.out.println("The end");
	}
	
}
