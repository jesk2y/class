package org.zerock.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extchecker {
    static String allowPattern = ".+\\.(gif|jpg|png)$"; //정규표현식

    public static boolean check(String fileName) {
      boolean result = false;

      Pattern p = Pattern.compile(allowPattern);
      // 문자열로 정의한 정규표현식은 사둉되기 전에 Pattern 클래스의 인스턴스로 컴파일되어야한다
        Matcher m = p.matcher(fileName);
        //Macher 객체는 임의의 입력 문자열이 패턴에 부합되는 지 여부를 판단해서 boolean값을 반환한다
        result = m.matches();

        return result;
    }

    public static void main(String[] args) {

        String name = "sdf412test.jpg";
        System.out.println(check(name));
    }
}
