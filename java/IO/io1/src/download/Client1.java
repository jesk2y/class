package download;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
    //bad code
    public static void main(String[] args)throws Exception {

        Socket socket = new Socket("10.10.10.85",7777);
        System.out.println(socket);

        InputStream in = socket.getInputStream();
        OutputStream out = new FileOutputStream("C:\\zzz\\내파일.jpg");

        byte[] buffer = new byte[1024*8];

        while(true){
            int count = in.read(buffer);

            if(count == -1){ break; }

            out.write(buffer,0,count);
        }

        in.close();
        out.close();

        socket.close();

    }
}
