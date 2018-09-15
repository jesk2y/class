package jr;

import java.io.OutputStream;
import java.util.Map;


public class Disclet extends AbstractJrlet {
    @Override
    public void service(String line, OutputStream out) throws Exception {
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("불쾌지수");
        out.write("<h1>discomfort index service</h1>".getBytes());

        Map<String, String> paramMap = parse(line);

        double temp = Double.parseDouble(paramMap.get("temp"));
        double humidity = Double.parseDouble(paramMap.get("humidity"));

        double discom = (1.8*temp)-0.55*(1-humidity/100)*(1.8*temp-26) + 32;

        out.write(("<h1> temp: " + paramMap.get("temp") + "</h1>").getBytes());
        out.write(("<h1> humidity: " + paramMap.get("humidity") + "</h1>").getBytes());
        out.write(("<hr/>").getBytes());
        out.write(("<h2> discomfort: " + discom + "</h2>").getBytes());
    }
}