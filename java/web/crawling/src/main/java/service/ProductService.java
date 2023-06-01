package service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class ProductService {
    private static ProductService ourInstance = new ProductService();

    public static ProductService getInstance() {
        return ourInstance;
    }

    private ProductService() {

    }

    public String getProductById(String id) throws IOException {
        File input = new File("C:\\zzz\\products.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        Element el = doc.select("#"+id).first();    //id를 얻어올 땐 #을 붙임\
        //class를 얻어올 땐 .을 붙임
//        System.out.println(el);

        Elements labels = el.select("label");   //태그 얻어올 땐 그냥
//        System.out.println(labels);
        for(Element element : labels){
            System.out.println(element.ownText());
        }
        return "";
    }

    public static void main(String[] args) throws Exception{
        ProductService obj = ProductService.getInstance();
        obj.getProductById("p1");
    }
}
