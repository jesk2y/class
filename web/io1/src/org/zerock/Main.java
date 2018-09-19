package org.zerock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    //bad code
    public static void main(String[] args)throws Exception {

        InputStream in = new FileInputStream("C:\\zzz\\sample.txt");
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.txt");

        byte[] buffer = new byte[5];

        long start = System.currentTimeMillis();
        //read write
        while(true){
            int count = in.read(buffer);
            System.out.println("COUNT: " + count);

            if(count == -1){ break;}
            out.write(buffer,0,count);
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        in.close();
        out.close();
    }
}
