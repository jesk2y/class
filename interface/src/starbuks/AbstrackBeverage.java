package starbuks;

import java.util.Scanner;

public abstract class AbstrackBeverage implements Beverage{
    Scanner scanner;

    public AbstrackBeverage(){  scanner = new Scanner(System.in);   }
    public void print(String msg){
        System.out.println(msg);
    }
}
