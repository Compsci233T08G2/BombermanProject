import java.util.Scanner;

public class TextBased {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of player one: ");
		Player p1 = new Player(0, 0, sc.nextLine());
		p1.intializingMap();
		System.out.println("Name of player two: ");
		Player p2 = new Player(0, 0, sc.nextLine());
		p1.move(0, 0, "down", p1);
		p1.move(0, 0, "down", p1);
		p1.move(0, 0, "down", p1);
		p1.move(0, 0, "down", p1);
		p1.move(0, 0, "down", p1);
		p1.move(0, 0, "down", p1);

	}

}
