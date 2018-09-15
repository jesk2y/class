import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy1 {

    //bad code
    public static void main(String[] args) throws Exception{

        String str = "https://cdn.videofarm.daum.net/vod/v59380rUIUtUtIzK44KqKjq/mp4_1280_720_2M/movie.mp4?px-time=1534763328&px-hash=4c49860803eada4c8eeaaa26cae9dc92&px-bps=2728365&px-bufahead=10";

        URL url = new URL(str);
        InputStream in = url.openStream();

//        InputStream in = new FileInputStream("C:\\zzz\\aaa.jpg");
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.mp4");

        while(true){

            //1 byte data
            int data = in.read();
            System.out.println(data);
            out.write(data);
            if(data == -1){
                break;
            }

        }

    }
}
