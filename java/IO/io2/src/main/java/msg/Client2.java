package msg;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    /*
    * getInputStream getOutputStream 이해안됨
    *(왜 저 위치에서 in과 out메소드가 호출되며 무엇을 받아들이고 내보내나?)
    * */
    public static void main(String[] args) throws Exception{

        Scanner keyScanner = new Scanner(System.in);    //내가 직접 입력하는값

        System.out.println("Input Your Message");

        String msg = keyScanner.nextLine() + "\n";  //입력한 값을 msg 저장
        // 갈때 역슬래시 포함해서 가야 서버에서 역슬래시를 받아들여서 처리함

        Socket socket = new Socket("10.10.10.83",7777);

        OutputStream out = socket.getOutputStream();    //처음에 서버 열리고 통로를 염
        Scanner inScanner = new Scanner(socket.getInputStream());   //서버에서 받아들이는값

        out.write(msg.getBytes()); //입력한 값을 서버에 보냄 // getBytes : String을 바이트코드로 인코딩해줌
        out.flush();

        String receiveMsg = inScanner.nextLine();   //.nextLine - 문자를 받음
        System.out.println("RECEIVE: " + receiveMsg);
        out.close();
        socket.close();

    }
}
