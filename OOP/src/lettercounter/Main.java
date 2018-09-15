package lettercounter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DataLoader loader = new DataLoader();
        LetterVOFinider finder = new LetterVOFinider();

        //파일을 읽어서 문자열을 얻는다.
        String text = loader.loadData("C:\\zzz\\노인과바다.txt");

        //문자열의 각 글자를 인식한다.
        //문자열을 char의 배열 같은 것으로 만들어야 한다.
        char[] arr = text.toCharArray();
        //만들어진 배열을 루프로 처리한다.
        for(int i = 0; i < arr.length; i++){
            //각 글자에 속하는 LetterVO의 count를 증가시킨다.
            char ch = arr[i];
            //LettterVO를 구할 수 있는 기능/존재를 통해서 얻어온다,
            int chValue = (int)ch;
            if(chValue < 65 || chValue > 90){
                continue;
            }

            LetterVO vo = finder.findByChar(ch);
            vo.count = vo.count + 1;
            //LetterVO vo=
            //vo.count += 1
        }
        System.out.println(Arrays.toString(finder.vos));
        //결과를 출력한다.


    }
}