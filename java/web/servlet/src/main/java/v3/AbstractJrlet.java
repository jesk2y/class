package v3;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract  class AbstractJrlet implements Jrlet{

    public Map<String, String> parse(String str)throws Exception{
        //?
        int idx = str.indexOf("?");
        //System.out.println(idx);
        String query = str.substring(idx + 1);
        //System.out.println(query);
        //&
        String[] midArr = query.split("&");

        if(midArr.length == 0){
            midArr = new String[]{query};
        }
        //System.out.println(Arrays.toString(midArr));
        //=
        Map<String, String> paramMap = new HashMap<>();
        for(int i = 0; i < midArr.length; i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");
            paramMap.put(paramArr[0],paramArr[1]);
        }
        return paramMap;
    }

    public abstract void service(String line, OutputStream out) throws Exception;
}
