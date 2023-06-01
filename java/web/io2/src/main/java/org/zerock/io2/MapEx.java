package org.zerock.io2;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {

        Map<String, String[]> wordMap = new HashMap<>();
        wordMap.put("월", new String[]{"점심"});
        wordMap.put("cat",new String[]{"고양이"});
        wordMap.put("dog", new String[]{"개"});

        System.out.println(wordMap.get("cat"));
    }
}
