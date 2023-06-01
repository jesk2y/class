package starbuks;

public class Main {
    public static void main(String[] args) {
        BendingMachine machine = new BendingMachine();

        Beverage result = machine.pushButton(1);

        result.getOrder();
    }

}
