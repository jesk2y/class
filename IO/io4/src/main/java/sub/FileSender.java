package sub;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileSender {
    /*
   Properties 클래스는 Hashtables의 하위 클래스이다.
   Hashtables를 상속 받았기 때문에 Map의 속성 즉, Key와 Value를 갖는다.
   HashMap과 큰 차이가 없지만, Properties 클래스는 파일 입출력을 지원한다.
   key=value 형식으로 작성 된 파일을 key와 value 로 나누어 저장할 때 유용하다.
    */
    private static Properties prop;//properties 사용

    static {
        try {
            String path = "C:\\webroot\\mime.properties";
            prop = new Properties();
            prop.load(new FileInputStream(path));   // 파일의 내용을 읽어서 키-값의 형태로 분류해 맵에 보관한다
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void sendFile(String path, OutputStream out) throws Exception {    // 오류나면 보고해줘야함
        int idx = path.lastIndexOf(".");    //.html에서 쩜 없애려고
        String subfix = path.substring(idx);    // 0 ~ idx-1 을 제외한 idx ~ 부터 출력

        System.out.println(subfix  +" : " + prop.getProperty(subfix) );

        out.write(new String("Content-Type: " + prop.getProperty(subfix) + ";\r\n\r\n").getBytes());

        //키값(html, jpg 등)을 넣었을때 text/html 이나 image/jpeg 같은게 소환된다


        File targetFile = new File("C:\\webroot\\" + path.substring(1));
        FileInputStream fin = new FileInputStream(targetFile);

        System.out.println("---------------------------------------------");
        System.out.println(fin);
        System.out.println("||" + targetFile.getAbsolutePath()+"||");

        try {
            byte[] buffer = new byte[1024 * 8];

            while (true) {
                int count = fin.read(buffer);
                if (count == -1) {
                    break;
                }
                out.write(buffer, 0, count);
            }
            fin.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
