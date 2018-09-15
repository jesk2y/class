import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3_1 {

    //bad code
    public static void main(String[] args) throws Exception {   //서버소켓때문에 함, 원래는 지워도딤
        /*
        주소창에 입력하는 키워드에 따라 다른 창이 출력된다
         */
        ServerSocket serverSocket = new ServerSocket(7777);

        while (true) {
            try (
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
                    //close 시켜줌 (try-with 구문)
            ) {
                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println(firstLine);

                String[] arr = firstLine.split(" ");
                String target = arr[1];

                outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                outputStream.write(new String("Cache-Control: private\r\n").getBytes());
                outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());

                if (target.equals("/")) {
                    System.out.println("skip");

                } else if (target.equals("/input.html")) {
                    System.out.println("input page service");
                    outputStream.write("<h1>input page service</h1>".getBytes());

                    File targetFile = new File("C:\\zzz\\" + target.substring(1));
                    FileInputStream fin = new FileInputStream(targetFile);

                    System.out.println(fin);
                    fin.close();

                } else if (target.startsWith("/bmi")) {
                    System.out.println("bmi service");
                    outputStream.write("<h1>bmi service</h1>".getBytes());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }//end catch
        }//end while
    }
}
