package menuorder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RestaurantVO[] restaurantVOS = {new RestaurantVO("버거킹", "몬스터와퍼, 통새우와퍼, 콰트로치즈와퍼, BLT뉴올리언스치킨버거"),
                new RestaurantVO("맥도날드", "빅맥, 상하이스파이스치킨버거, 1955버거, 쿼터파운더치즈, 맥모닝, 슈슈버거, 베이컨 토마토 디럭스"),
                new RestaurantVO("롯데리아", " AZ버거, 모짜렐라 인더 버거, 와규 오리지널"),
                new RestaurantVO("맘스터치", "싸이버거, 마살라버거, 딥치즈버거, 리샐버거, 휠렛버거"),
                new RestaurantVO("서브웨이", "이탈리안 BLT, 로티세리 치킨, 로스트 비프, 서브웨이 클럽")};

        System.out.println("메뉴입력");
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();

        RestaurantVOfinder rvf = new RestaurantVOfinder(restaurantVOS);
        rvf.storeReturn(menu);


    }
}