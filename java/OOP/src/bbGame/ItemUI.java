package bbGame;

import java.util.Scanner;

public class ItemUI {

    ItemSystem si;

    public ItemUI(ItemSystem si) {
        this.si = si;
    }

    public void playGame() {
        System.out.println("Game Start!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            scanner.nextLine();
            ItemVO is = si.pick();
            System.out.println(is);
            if (is.value == "당첨") {
                break;
            }
        }
    }
}
