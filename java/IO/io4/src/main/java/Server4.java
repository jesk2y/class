import jr.Jrlet;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import sub.FileSender;
public class Server4 {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        JrletFactory factory = new JrletFactory();


        while (true) {

            try (
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
            ) {
                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println(firstLine);

                String[] arr = firstLine.split(" ");

                // /input.html, /bmi, /aaa.jpg
                // if-else 말고도 확장자 체크하는 정규표현식 사용가능
                String target = arr[1];


                if(target.contains("test") == false){
                    outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                    outputStream.write(new String("Cache-Control: private\r\n").getBytes());
                }

                if(target.endsWith(".html") ||
                        target.endsWith(".jpg") ||
                        target.endsWith(".mp3") ||
                        target.endsWith(".mp4")){

                    System.out.println("정적인 컨텐츠");
                    FileSender sender = new FileSender();
                    sender.sendFile(target, outputStream);

                }else{
                    Jrlet jrlet = factory.get(target);
                    jrlet.service(target,outputStream);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }//end catch
        }//end while
    }
}
