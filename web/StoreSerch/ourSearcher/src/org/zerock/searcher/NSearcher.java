package org.zerock.searcher;

import org.zerock.domain.Store;

import java.util.ArrayList;
import java.util.Collections;

public class NSearcher extends AbstractSearcher {

    NSearcher() throws Exception {
    }

    @Override
    public ArrayList<Store> search() {

        try {
            load("C:\\zzz\\1_store.txt");
            load("C:\\zzz\\2_store.txt");
            load("C:\\zzz\\3_store.txt");
            load("C:\\zzz\\4_store.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("현재 위도는?");
        //double lat = Double.parseDouble(scanner.nextLine());
        double lat = 33.412755;
        System.out.println("현재 경도는?");
        //double lng = Double.parseDouble(scanner.nextLine());
        double lng = 126.424715;

        System.out.println(lat +" : " + lng);

        Collections.sort(storeList, (s1, s2)->{
            double d1 = Math.sqrt( Math.pow(lat - s1.getLat(),2) + Math.pow(lng - s1.getLng(),2) );
            double d2 = Math.sqrt( Math.pow(lat - s2.getLat(),2) + Math.pow(lng - s2.getLng(),2) );

            if(d1 < d2){
                return -1;
            }else if( d1 > d2){
                return 1;
            }
            return 0;
        });

        for (Store store:storeList) {
            System.out.println(store);
        }

        return null;
    }
}
