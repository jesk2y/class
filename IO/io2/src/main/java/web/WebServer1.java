package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer1 {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Reader Server");

        while (true) {

            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());    //ip주소

            OutputStream out = socket.getOutputStream();

            File file = new File("C:\\zzz\\img2\\8.gif");

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            // 지금부터 내가 보내는 메세지는 http/1.1로 이루어져있고 200은 404같은거
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: " + file.length() + "\r\n").getBytes());
            out.write(new String("Content-Type: image/jpeg; charset=UTF-8\r\n\r\n").getBytes());
            //중요 : 지금부터 내가 보내는 컨텐츠는 (text/html)이야 (MIME 타입)

            FileInputStream fin = new FileInputStream(file);
            byte[] buffer = new byte[1024 * 8];

            while (true) {
                try {
                    int count = fin.read(buffer);
                    if (count == -1) {
                        break;
                    }
                    out.write(buffer, 0, count);
                    out.flush();    // 남아있는 데이터를 강제로 내보냄(고인물 뺴내기)
                } catch (Exception e) {

                }
            }
//            out.close();
//            socket.close();
        }

    }
}
