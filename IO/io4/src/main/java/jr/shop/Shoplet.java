package jr.shop;

import jr.AbstractJrlet;
import jr.shop.ShopList;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Shoplet extends AbstractJrlet {
    @Override
    public void service(String line, OutputStream out) throws Exception {
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());

        Map<String, String> paramMap = parse(line);

        String style = paramMap.get("style");

        out.write(("<h1 style=\"text-align:center\">" + paramMap.get("style")  +"</h1>").getBytes());
        out.write(("<hr/>").getBytes());

        ShopList shopList = new ShopList();
        System.out.println("style: "+ style);
        System.out.println("shopList: " + shopList);


        List<Shop> result = shopList.getShop(style);


        for (Shop obj:result ) {
            out.write( ("<h1><a href=\""+ obj.getLink()+"\" target=\"_blank\" style=\"font-size:18px; color:#000\">"+obj.getName()+"</a></h1>" ).getBytes("UTF-8"));
            out.write( ("<p style=\"font-size:14px;\">"+ obj+"</p>" ).getBytes("UTF-8"));
            out.write("<hr/>".getBytes("UTF-8"));

        }


    }
}
