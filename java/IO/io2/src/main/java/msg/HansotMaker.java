package msg;

import java.util.HashMap;
import java.util.Map;

public class HansotMaker implements MsgMaker {

    Map<String, String[]> stringMap;

    public HansotMaker(){
        stringMap = new HashMap<>();
        stringMap.put("월", new String[]{"교자만두","빅치킨마요"});
        stringMap.put("화", new String[]{"교자만두"});
        stringMap.put("수", new String[]{"교자만두","새치고기고기"});
        stringMap.put("목", new String[]{"교자만두"});
        stringMap.put("금", new String[]{"교자만두","동백"});
        stringMap.put("토", new String[]{"교자만두","진달래"});
        stringMap.put("일", new String[]{"교자만두"});
    }

    /*
     HashMap은 Map을 구현한다. Key와 value를 묶어 하나의 entry로 저장한다는 특징을 갖는다
     Map 인터페이스의 한 종류로 ( "Key", value) 로 이뤄져 있다
     key 값은 중복이 불가능 하고 value는 중복이 가능. value에 null값도 사용 가능하다
    */

    @Override
    public String[] getMsg(String key) {
        return stringMap.get(key);  //get(key) = value값, 서버의 String[] answer가 됨
    }
}