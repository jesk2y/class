import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println(serverSocket);

        while(true){
            try {
                Socket client = serverSocket.accept();
                System.out.println(client);

                OutputStream out = client.getOutputStream();
                InputStream fin = new FileInputStream("C:\\zzz\\aaa.mp3");

                byte[] buffer = new byte[1024 * 8];

                while (true) {
                    int count = fin.read(buffer);
                    if (count == -1) {
                        break;
                    }
                    out.write(buffer, 0, count);
                }
            }catch(Exception e){

            }//end catch

        }//end while


    }
}
