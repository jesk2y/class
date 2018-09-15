package order;

import java.util.Scanner;

public class Main {

    public static void show(Menu menu) {
        System.out.println(menu.name);
        System.out.println(menu.size);
        System.out.println(menu.price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu[] arr = new Menu[5];

        arr[0] = new Menu("떡볶이", "소", 3000.0);
        arr[1] = new Menu("만두", "중", 3500.0);
        arr[2] = new Menu("치즈라면", "대", 4500.0);
        arr[3] = new Menu("순대", "소", 3000.0);
        arr[4] = new Menu("비빔밥", "중", 4500.0);

        System.out.println("국수집1");
        for (Menu menu : arr) {
            System.out.printf("%s : %s : %f\n", menu.name, menu.size, menu.price);
        }
        System.out.println("메뉴의 번호를 입력하시고..종료는 -1");

        Menu[] ordered = new Menu[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("메뉴번호는?");
            int menuNo = Integer.parseInt(scanner.nextLine());
            if (menuNo == -1) {
                break;
            }
            ordered[i] = arr[menuNo];
            System.out.println("수량을 입력해 주세요");
            int qty = Integer.parseInt(scanner.nextLine());
            ordered[i].qty = qty;

        } // end for
        double sum = 0;
        for (int i = 0; true; i++) {
            if (ordered[i] == null) {
                break;
            }
            sum += ordered[i].getTotal();
            System.out.println(ordered[i].name + " " + ordered[i].getTotal() + " " + ordered[i].qty);
        }

        System.out.println("--------------------------------");
        System.out.println("TOTAL: " + sum);
        // 메뉴를 보여주는 기능
        // 주문받는 기능
        // 영수증 출력기능
    }
}