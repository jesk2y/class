package hsm;

import java.io.InputStream;
import java.net.URL;

public class MultiRequest {

    //bad code
    public static void main(String[] args)throws Exception {
        String str = "naver.com";
        for(int i=1; i<=2400; i++){

            int finalI = i;
            new Thread(() -> {

                try {
                    URL url = new URL(str);
                    System.out.println(str);
                    InputStream in = url.openStream();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }
}
