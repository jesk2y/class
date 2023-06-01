package org.zerock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileCopy1 {

    //bad code
    public static void main(String[] args) throws Exception{

        String str ="https://image-comic.pstatic.net/webtoon/20853/1149/20180702171134_af18e7fca72bb0de60b5cedcfb0096e1_IMAG01_15.jpg";

        URL url = new URL(str);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

        InputStream in = con.getInputStream();

        //InputStream in = new FileInputStream("C:\\zzz\\aaa.jpg");
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.jpg");

        while(true){

            //1 byte data
            int data = in.read();
            System.out.println(data);
            out.write(data);
            if(data == -1){
                break;
            }//end if

        }//end while

    }
}
