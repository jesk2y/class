package service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class KeywordService {
    private static KeywordService ourInstance = new KeywordService();

    public static KeywordService getInstance() {
        return ourInstance;
    }

    private KeywordService() {
    }

    public List<String> find()throws Exception{

        List<String> result = new ArrayList<>();

        String path = "https://datalab.naver.com/keyword/realtimeList.naver?where=main";
        Document doc = Jsoup.connect(path).get();
//        System.out.println(doc);

        Elements els = doc.select(".list");

        int idx = 0;
        for(Element el : els ){
            Element span = el.select("span").first();
            String text = span.ownText();

            if(text.trim().length() == 0){
                //trim:공백문자를 없애는것, 공백문자 없애고 난 길이가 0이면 위로
                continue;
            }

            result.add(text);
            if(idx == 19){
                break;
            }
            idx++;
        }

        return result;
    }

    public static void main(String[] args)throws Exception {
        List<String> list = KeywordService.getInstance().find();
        System.out.println(list);
    }
}
