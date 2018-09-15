package restfinder;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Restaurant[] res = {
                new Restaurant("이문설렁탕", new String[]{"설렁탕","곰탕","도가니탕"}),
                new Restaurant("청진옥", new String[]{"해장국","감자탕"}),
                new Restaurant("삼양통닭", new String[]{"치킨","삼계탕"}),
                new Restaurant("뚝배기집", new String[]{"된장찌개","김치찌개","순두부찌개"})
        };

        //음식점 정보들이 존재해야 한다.
        RestaurantFinder finder = new RestaurantFinder(res);

        //키보드에서 먹고싶은 메뉴를 입력받는다.
        //String menu ="삼계탕";
        Scanner scanner = new Scanner(System.in);
        System.out.println("메뉴를 입력해주세요: ");
        String menu = scanner.nextLine();

        //음식점 정보들 중에서 해당 메뉴를 파는 음식점을 찾는다.
        Restaurant[] result = finder.findByMenu(menu);

        //출력한다.
        System.out.println(Arrays.toString(result));
    }
}