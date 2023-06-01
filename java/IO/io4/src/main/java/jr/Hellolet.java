package jr;

import java.io.OutputStream;

public class Hellolet extends AbstractJrlet{

    @Override
    public void service(String line, OutputStream out) throws Exception{
        /*
       추상메소드 종류: 인터페이스/추상클래스(인터페이스가 견고함)
       인터페이스는 다중상속 가능
        */
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("hello service");
        out.write("<h1>Hello service</h1>".getBytes());

    }

}
