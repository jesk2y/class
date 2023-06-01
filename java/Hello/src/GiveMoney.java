import java.util.Scanner;

public class GiveMoney {	
	public static void main(String[] args) {	
		int money = 0;
		
		System.out.println("시급이면 1, 일급이면 2를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int select = Integer.parseInt(scanner.nextLine());
		
		if (select == 1) {
			System.out.println("일한 시간을 입력하세요.");
			int time = Integer.parseInt(scanner.nextLine());
			money = time * 7530;
			
		}else if (select == 2) {
			System.out.println("일한 날수를 입력하세요.");
			int day = Integer.parseInt(scanner.nextLine());
			money = day * 8 * 7530;
			
		}else {
			System.out.println("다시 입력하세요");
		}
		
		System.out.printf("총 월급은 %d 원 입니다.", money);
		
	}
}
