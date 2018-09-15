import jr.Jrlet;

import java.io.FileInputStream;
import java.util.Properties;

public class JrletFactory {
    //쿼리스트링 : ?뒤에 나오는거

    public Properties prop;

    public JrletFactory()throws Exception{
        String path ="C:\\webroot\\jrlet.properties";
       prop = new Properties(); // 얘는 유지용이 아닌 인스턴스이므로 로컬밸류로 잡음(ㄴㄴ 인스턴스)
        prop.load(new FileInputStream(path));

        System.out.println(prop);

    }

    public Jrlet get(String line)throws Exception{

        int idx = line.indexOf("?");    // 물음표 없으면 -1나옴


        String targetURL = idx == -1?line : line.substring(0,idx);
        String className = prop.getProperty(targetURL);

        System.out.println("================================");
        System.out.println("CLASS NAME: "+className);

        Object obj = Class.forName(className).newInstance();
        // Class.forName() 메소드를 호출하면 인스턴스 생성과 초기화가 이루어짐
        // .newInstance()메소드를 호출해서 인스턴스를 생성해야 함
        return (Jrlet)obj;
        //다운캐스팅은 추상클래스나 인터페이스로만

    }

}
