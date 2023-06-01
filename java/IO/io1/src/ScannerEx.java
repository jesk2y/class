import java.util.Scanner;

public class ScannerEx {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 입력 받기 ");
        int value = scanner.nextInt();
        scanner.nextLine();

        System.out.println(value);

        System.out.println("문자 입력 받기");
        String str = scanner.nextLine();

        System.out.println("------------------------------");
        System.out.println("STR: " + str);
    }

}
