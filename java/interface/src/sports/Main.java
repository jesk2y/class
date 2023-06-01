package sports;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Player[] arr = {
                new Player("홍길동", 0.3),
                new Player("임꺽정", 0.4),
                new Player("황진이", 0.5)
        };

        double target = 0.45;

        Arrays.sort(arr, new Comparator<Player>(){

            @Override
            public int compare(Player o1, Player o2) {
                double gap1 = Math.abs(o1.rate - target);
                double gap2 = Math.abs(o2.rate - target);

                if(gap1 > gap2){
                    return 1;
                }else if(gap1 < gap2){
                    return -1;
                }
                return 0;
            }

        });

    }
}