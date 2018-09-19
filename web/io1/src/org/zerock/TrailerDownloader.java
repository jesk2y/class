package org.zerock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class TrailerDownloader {

    //bad code
    public static void main(String[] args)throws Exception {

        String path ="https://cdn.videofarm.daum.net/vod/v95938e81Q3HaVBFFKDBa1B/mp4_1280_720_2M/movie.mp4?px-time=1534828391&px-hash=82490fa4b42ee5f62514d7965a02239b&px-bps=2950105&px-bufahead=10";

        URL url = new URL(path);
        InputStream in = url.openStream();
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.mp4");

        byte[] buffer = new byte[1024*8];

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
