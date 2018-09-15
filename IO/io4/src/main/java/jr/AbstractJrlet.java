package jr;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractJrlet implements Jrlet {
    public static Map<String, String> parse(String str)throws Exception{    // static임
        //?
        int idx = str.indexOf("?"); // indexOff : 해당 문자가 들어있는 위치를 알려줌
        String query = str.substring(idx+1);

        //&
        String[] midArr = query.split("&");

        if(midArr.length == 0){
            midArr = new String[]{query};
        }

        //=
        Map<String, String> paramMap = new HashMap<>();
        for(int i=0; i<midArr.length;i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");
            paramMap.put(paramArr[0],paramArr[1]);
        }
        return paramMap;
    }



}
