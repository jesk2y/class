package org.zerock.searcher;

import java.util.HashMap;
import java.util.Map;

public class SearchFactory {

    Map<String, AbstractSearcher> map;

    public SearchFactory()throws Exception{
        map = new HashMap<>();
        map.put("A", new ASearcher());
        map.put("N", new NSearcher());
    }

    public AbstractSearcher find(String str){
        return map.get(str);
    }

}
