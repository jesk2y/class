package Salary;

import java.util.Scanner;

public abstract class AbstractMaker {

    Scanner scanner;

    public AbstractMaker(){
        this.scanner = new Scanner(System.in); // 생성자 초기화해야하므로
    }

    public double inputD(String msg){
        System.out.println(msg);
        return Double.parseDouble(scanner.nextLine());
    }

    public double inputI(String msg){
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public abstract Salary make();

}
