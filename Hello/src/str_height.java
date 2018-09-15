import java.util.Scanner;

public class str_height {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("키를 입력하시오(미터 기준)");

		float person = Float.parseFloat(scanner.nextLine());
		System.out.println("각도를 입력하시오(예각)");

		double angle = Double.parseDouble(scanner.nextLine());

		angle = (Math.PI/180) * angle; //

		System.out.println("건물과의 거리를 입력하시오(미터 기준)");
		float dist = Float.parseFloat(scanner.nextLine());

		double height = dist * Math.tan(angle);
		System.out.println(String.format("%.4g", height + person));

	}

}