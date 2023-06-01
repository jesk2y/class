import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public static Map<String, String> parse(String str)throws Exception{
        //?
        int idx = str.indexOf("?"); // indexOff : 해당 문자가 들어있는 위치를 알려줌
//        System.out.println(idx);
        String query = str.substring(idx+1);
//        System.out.println(query);
        //&
        String[] midArr = query.split("&");

        if(midArr.length == 0){
            midArr = new String[]{query};
        }
//        System.out.println(Arrays.toString(midArr));
        //=
        Map<String, String> paramMap = new HashMap<>();
        for(int i=0; i<midArr.length;i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");
            paramMap.put(paramArr[0],paramArr[1]);
        }
        return paramMap;
    }

    public static void main(String[] args)throws Exception {
        Map<String,String> paramMap = parse("/bmi?height=150&weight=50");
        System.out.println("Height: " + paramMap.get("height"));
        System.out.println("weight: " + paramMap.get("weight"));
        System.out.println(parse("/login?id=aaa"));
    }
}
