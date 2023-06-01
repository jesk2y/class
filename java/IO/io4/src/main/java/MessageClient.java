import com.sun.security.ntlm.Server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessageClient {
    //bad code
    public static void main(String[] args)throws Exception {

        String i1 = "  　／⌒ヽ"+
                    "　 ∩ ＾ω＾）"+
                    "　 |　　 ⊂ﾉ"+
                    "　｜　　 _⊃"+
                    "　 し ⌒";

        Map<String, String > iconMap = new HashMap<>();
        iconMap.put("@i1","\n" + i1 + "\n");
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("CLIENT READY");

        while(true){
            try(
                    Socket socket = serverSocket.accept();
                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    //readUTF 할수있음  (문자열 출력)
                   ){

                System.out.println(socket);
                String message = din.readUTF();

                if(message.contains("@i1")){
                    System.out.println(iconMap.get("@i1"));
                }

                System.out.println(message);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }


        }

    }
}
