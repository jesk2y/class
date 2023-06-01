import java.util.Scanner;

public class RspGame_2 {

	public static int doA() {
		System.out.println("값을 입력하세요.(가위:0, 바위:1, 보:2)");
		Scanner scanner = new Scanner(System.in);
		int com = (int) (Math.random() * 3);
		int user = 0;
		while (true) {
			user = Integer.parseInt(scanner.nextLine());
			if(user == 0 || user == 1 || user == 2) {
				break;
			}else {
				System.out.println("잘못 입력하였습니다");
				System.out.println("다시 입력하세요.(가위:0, 바위:1, 보:2)");
			}
		}
		System.out.println("[당신: " + (user == 0 ? "가위]": user == 1 ? "바뤼]" : "보]") + " [컴퓨터: " + (com == 0 ? "가위]": com == 1 ? "바뤼]" : "보]"));

		int result = com - user;
		if (result < 0) {
			result += 3;

		}
		return result;
	}

	public static void main(String[] args) {

		int num = 0;
		int user_state = 0;
		int com_state = 0;

		while (true) {

			int result = doA();

			if (num == 0 && result == 0) {
				System.out.println("비겼으니 다시 시작하세요");
				continue;
			}

			if (result == 2) {
				System.out.println("현재 이긴 상태");
				user_state = 1;
				com_state = 0;
				num += 1;

			} else if (result == 1) {
				System.out.println("현재 진 상태");
				com_state = 1;
				user_state = 0;
				num += 1;

			} else if (result == 0) {
				System.out.print((num + 1) + "판만에");
				if (user_state == 1) {
					System.out.println(" 이김");
				} else if (com_state == 1) {
					System.out.println(" 짐");
				}
				System.exit(0);
			}

		}

	}

}