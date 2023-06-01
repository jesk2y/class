package jr.sevice;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum MessageService {

    INSTANCE;
    private Map<String, String> ipMap;

    MessageService (){

        ipMap = new HashMap<>();
        ipMap.put("조성익","10.10.10.84");
        ipMap.put("김진솔","10.10.10.83");
        ipMap.put("주은지","10.10.10.82");
        ipMap.put("정영준","10.10.10.93");
        ipMap.put("박고은","10.10.10.92");
        ipMap.put("홍아람","10.10.10.91");
        ipMap.put("황인재","10.10.10.90");

    }

    public void sendMessage(String target, String msg)throws Exception{

        String ipAddr = ipMap.get(target);
        Socket socket = new Socket(ipAddr,7777);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF(msg);
        dos.flush();
        dos.close();
        socket.close();

    }

}
