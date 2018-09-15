package hsm;

public class Main {

    public static void main(String[] args) {
        Horse[] arr = new Horse[3];
        arr[0] = new Horse("조말");
        arr[1] = new Horse("김말");
        arr[2] = new Horse("주말");

        for (Horse h:arr) {
            h.start();
        }

//        Looper looper = new Looper();
//
//        new Thread(() -> {
//            looper.loop();
//        }).start();
//
//        new Thread(() -> {
//            looper.loop();
//        }).start();
//
//        looper.loop();
    }
}
