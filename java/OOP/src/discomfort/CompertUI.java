package discomfort;

import java.util.Scanner;

public class CompertUI {

    CompertIndexer com;

    public CompertUI() {
        this.com = com;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("온도를 입력해주세요");
        double temp = Double.parseDouble(scanner.nextLine());
        System.out.println("습도를 입력해주세요");
        double hum = Double.parseDouble(scanner.nextLine());

        double result = this.com.calc(temp, hum);
        System.out.println(result);
    }
}
