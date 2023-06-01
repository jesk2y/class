import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class TrailerDownloader {

    //bad code
    public static void main(String[] args)throws Exception {
        String path = "https://cdn.videofarm.daum.net/vod/ve993eUudeUxhXIdVWIh9LV/mp4_1280_720_2M/movie.mp4?px-time=1534828802&px-hash=6d43e10a61ec6e5e3d9a05124f50dbef&px-bps=2850599&px-bufahead=10";

        URL url = new URL(path);

        InputStream in = url.openStream();
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.mp4");

        byte[] buffer = new byte[1024*8];

        long start = System.currentTimeMillis();
        //read write
        while(true){
            int count = in.read(buffer);
            System.out.println("COUNT: " + count);
            if(count == -1){ break; }
            out.write(buffer,0,count);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        in.close();
        out.close();

    }
}
