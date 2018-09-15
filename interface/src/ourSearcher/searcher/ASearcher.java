package ourSearcher.searcher;


import ourSearcher.domain.Store;

import java.util.ArrayList;

public class ASearcher extends AbstractSearcher{
    ASearcher() throws Exception {
    }

    @Override
    public ArrayList<Store> search(){
        System.out.println("지역을 검색합니다. 1.제주, 2.전라, 3.강원, 4.경상");
        String area = scanner.nextLine();

        String fileName = "C:\\zzz\\" + area + "_store.txt";

        try {
            load(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
