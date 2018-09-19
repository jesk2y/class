package v1;


import v1.sub.FileSender;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Server4 {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);

        while(true){

            try(
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
            ){
                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println(firstLine);

                String[] arr = firstLine.split(" ");

                // /input.html /bmi /aaa.jpg
                String target = arr[1];

                outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                outputStream.write(new String("Cache-Control: private\r\n").getBytes());

                if(target.endsWith(".html") || target.endsWith(".jpg") ||target.endsWith(".mp3")){

                    System.out.println("정적인 컨텐츠");
                    FileSender sender = new FileSender();
                    sender.sendFile(target, outputStream);

                }else {

                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }//end catch
        }//end while
    }
}
