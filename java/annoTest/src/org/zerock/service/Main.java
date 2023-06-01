package org.zerock.service;

import org.zerock.anno.BGM;
import org.zerock.anno.Trailer;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        String prefix = "org.zerock.service.";

        System.out.println("영화 이름을 입력하세요");
        String heroName = scanner.nextLine();

        Class clz = Class.forName(prefix + heroName);
        Object obj = clz.newInstance();

        BGM bgm = (BGM) clz.getAnnotation(BGM.class);
        String music = bgm.value();
        int duration = bgm.duration();

        System.out.println(music + " : " + duration);
        System.out.println(obj);

        Method[] methods = clz.getDeclaredMethods();

        for(Method method : methods){
            Trailer anno = method.getAnnotation(Trailer.class);
            // 트레일러라는 어노테이션이 있는지 확인

            if(anno != null){
                method.invoke(obj,null);    //invoke : 호출하다
                //파라미터가 없으므로 null
            }
        }

    }
}
