package org.zerock;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {

    //bad code
    public static void main(String[] args)throws Exception {

        Socket socket = new Socket("127.0.0.1", 7777);
        System.out.println(socket);

        InputStream in = socket.getInputStream();
        OutputStream out = new FileOutputStream("C:\\zzz\\샘플.jpg");

        byte[] buffer = new byte[1024*8];

        while(true){
            int count = in.read(buffer);
            System.out.println("COUNT: " + count);
            if(count == -1){ break;}
            out.write(buffer,0,count);
        }

        in.close();
        out.close();

        socket.close();

    }
}
