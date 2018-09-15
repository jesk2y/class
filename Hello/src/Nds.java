import java.util.Scanner;
public class Nds{
	public static int rsp() {
		Scanner scanner = new Scanner(System.in);
		int user = 0;
		int com = (int)(Math.random()*3);
		System.out.println("가위:0, 바위:1, 보:2");
		while(true) {
			user = Integer.parseInt(scanner.nextLine());

			if(user == 0 || user == 1 || user == 2) {
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		int result = com - user;
		if(result <0) {
			result += 3;
		}
		System.out.println("[당신: " + (user == 0 ? "가위]": user == 1 ? "바뤼]" : "보]") + " [컴퓨터: " + (com == 0 ? "가위]": com == 1 ? "바뤼]" : "보]"));
		return result;

	}
	public static void main(String[] args) {

		int user_state = 0; // 0은 진거, 1은 이긴거
		int com_state = 0;
		int num = 0;

		while(true) {
			int result = rsp();
			if(result == 0 && num == 0) {
				System.out.println("비겼습니다. 다시 입력해주세요.");
				continue;
			}

			if(result == 1) {
				System.out.println("현재 진 상태입니다.");
				user_state = 0;
				com_state = 1;
				num += 1;
			}else if(result == 2){
				System.out.println("현재 이긴 상태입니다.");
				user_state = 1;
				com_state = 0;
				num += 1;
			}else if(result == 0) {
				if(user_state == 0) {
					System.out.println("졌습니다.");
				}else {
					System.out.println("이겼습니다.");
				}
				System.exit(0);
			}
		}
	}
}
