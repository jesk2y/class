package jr;

import jr.sevice.MessageService;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Map;

public class Messagelet extends AbstractJrlet {
    // 브라우저가 get 방식으로 전홍할때는 자동으로 인코딩을 함
    @Override
    public void service(String line, OutputStream out) throws Exception {

        Map<String, String> paramMap = parse(line);

        System.out.println(paramMap);

        String content = paramMap.get("content");
        String deContent = URLDecoder.decode(content,"UTF-8");
        String deTarget = URLDecoder.decode(paramMap.get("target"), "UTF-8");
        System.out.println(deContent);

        MessageService service = MessageService.INSTANCE;

        service.sendMessage(deTarget, deContent);

        out.write(new String("Content-Type: text/html; charset=UTf-8\r\n\r\n").getBytes());
        System.out.println("message service");
        out.write("<h1>정상적으로 전송되었습니다</h1>".getBytes("UTF-8"));
    }
}
