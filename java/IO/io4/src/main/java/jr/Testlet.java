package jr;

import java.io.OutputStream;
import java.util.Map;

public class Testlet extends AbstractJrlet {
    @Override
    public void service(String line, OutputStream out) throws Exception {
        System.out.println("Testlet running");

        Map<String, String> paramMap = parse(line);

        String gender = paramMap.get("target");



//        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("test service");
        out.write(new String("HTTP/1.1 301 MovedPermanently\r\n").getBytes());
        out.write("Location: /b.html\r\n".getBytes());
    }
}
