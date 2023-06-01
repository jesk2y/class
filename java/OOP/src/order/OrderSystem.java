package order;

import java.util.Scanner;

public class OrderSystem {
	Menu[] arr;
	private Object orderdMenu;

	public OrderSystem(Menu[] menus) {
		this.arr = menus;
	}

	public void showMenus() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public void order() {
		Scanner scanner = new Scanner(System.in);
		Menu[] orderedMenu = new Menu[3];

		for (int i = 0; i < orderedMenu.length; i++) {
			System.out.println("메뉴번호는?");
			int idx = Integer.parseInt(scanner.nextLine());
			orderedMenu[i] = this.arr[idx];
			System.out.println("수량은?");
			int qty = Integer.parseInt(scanner.nextLine());
			orderedMenu[i].qty = qty;
		}
		showBills(orderedMenu);
	}
	private void showBills(Menu[] orderedMenu) {}
}
