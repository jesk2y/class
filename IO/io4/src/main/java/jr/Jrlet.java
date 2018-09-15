package jr;

import java.io.OutputStream;

public interface Jrlet {    //Singleton : 인스턴스를 하나만 만듬
    void service(String line, OutputStream out) throws Exception;
}
