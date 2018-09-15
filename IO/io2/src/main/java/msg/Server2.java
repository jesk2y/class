package msg;
import msg.domain.MovieMaker;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server2 {

    //bad code
    public static void main(String[] args) throws Exception{
        //소켓 관련 코드짤때는 첨에 무조건 예외처리 해줌
        //아이피 접속하고 할때부터 소켓사

        Map<String, MsgMaker> makerMap = new HashMap<>();

        makerMap.put("1",new HansotMaker());
        makerMap.put("2",new MovieMaker());
        MsgMaker maker = null;

//        MsgMaker maker = new HansotMaker();  // 클래스명 바꿔줌
        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("Ready");

        while(true) {   //클라이언트의 메세지 계속 받아야하므로 멈춤 누를때까지 while문 계속 돌아감

            // 소켓 접속 요청이 올때까지 대기합니다.
            Socket socket = serverSocket.accept();

            System.out.println(socket);

            InputStream in = socket.getInputStream();  //읽기
            Scanner scanner = new Scanner(in);  //Scanner : in값만 파싱 및 처리할거이므로


            OutputStream out = socket.getOutputStream();    //쓰기

            String str = scanner.nextLine();
            //1.수 2,a
            System.out.println("CLIENT: " + str);

            String[] inputArr = str.split(","); //1,수 -> {1,수}

            maker = makerMap.get(inputArr[0]);  //
            String[] answer = maker.getMsg(inputArr[1]);
            //한솥메이커의 getMsg메소드에 str을 넣은후 얻은 키배열이 answer배열

            String resultMsg = Arrays.toString(answer)+"\n";

            out.write(resultMsg.getBytes());       //메뉴들의 바이트값을 클라이언트에게 보낸다
            out.flush();

            out.close();
            scanner.close();
            in.close();
            socket.close();

        }//end while
        //pm:05:12 에서 토큰은 pm 05 12
        //serverSocket.close();

    }
}