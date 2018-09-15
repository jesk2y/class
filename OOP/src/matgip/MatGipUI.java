package matgip;

import java.util.ArrayList;
import java.util.Scanner;

public class MatGipUI {
    private MatGipService service;
    private Scanner scanner;

    public MatGipUI(MatGipService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void init(){
        System.out.println("1번 등록, 2번 찾기, -1번 종료");
        int oper = Integer.parseInt(scanner.nextLine());
        if (oper == -1){
            return;
        }
        if (oper == 1){
            registerUI();
        }else if(oper==2){
            findUI();
        }
        init();

    }

    private void registerUI(){
        System.out.print("맛집의 지역을 입력해주세요: ");
        String place = scanner.nextLine();
        System.out.print("맛집의 이름을 입력해주세요: ");
        String name = scanner.nextLine();
        System.out.print("맛집의 메뉴를 입력해주세요: ");
        String menu = scanner.nextLine();

        MatGip obj = new MatGip(place,name,menu);

        service.register(obj);
    }

    private void findUI(){
        System.out.print("현재 지역을 입력해주세요: ");
        String place = scanner.nextLine();
        ArrayList<MatGip> result = service.findByPlace(place);
        System.out.println(result);



    }


}
