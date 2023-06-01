package bbGame;

public class Main {

    public static void main(String[] args) {
        ItemVO[] arr = {new ItemVO("꽝"),
                new ItemVO("꽝"),
                new ItemVO("꽝"),
                new ItemVO("꽝"),
                new ItemVO("당첨")};

        ItemSystem is = new ItemSystem(arr);
        is.shuffle();
        ItemUI ui = new ItemUI(is);
        ui.playGame();
    }
}
