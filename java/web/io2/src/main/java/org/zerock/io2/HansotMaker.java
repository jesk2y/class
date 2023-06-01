package org.zerock.io2;

import java.util.HashMap;
import java.util.Map;

public class HansotMaker implements MsgMaker {

    Map<String, String[]> stringMap;

    public HansotMaker(){
        stringMap = new HashMap<>();
        stringMap.put("월", new String[]{"AAA","AAB"});
        stringMap.put("화", new String[]{"BAA","BAB"});
        stringMap.put("수", new String[]{"CAA","CAB"});
        stringMap.put("목", new String[]{"DAA","DAB"});
        stringMap.put("금", new String[]{"EAA","EAB"});


    }

    @Override
    public String[] getMsg(String key) {
        return stringMap.get(key);
    }
}
