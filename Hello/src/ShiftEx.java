import java.util.Scanner;

public class ShiftEx {
	// goto
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // c + shift + o -> 자동 import됨
		System.out.println("값을 입력하세요.(가위:0, 바위:1, 보:2)");
		int user = Integer.parseInt(scanner.nextLine());
		int com = (int) (Math.random() * 3);

		System.out.println("user: " + user);
		System.out.println("com: " + com);

		int result = com < user ? com + 3 - user : com - user;

		if (result == 2) {
			System.out.println("이김");
		} else if (result == 1) {
			System.out.println("짐");
		} else {
			System.out.println("비김");
		}

	}
}