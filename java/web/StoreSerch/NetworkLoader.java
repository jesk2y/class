package org.zerock;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class NetworkLoader implements MovieLoader {


    @Override
    public ArrayList<Movie> getList() throws Exception {

        String path = "https://cafeattach.naver.net/48dd54e4f0a9ac705fb9dfedd330483092c03edcdd/20180820_32_cafefile/28363273_1534739545532_FUtCow_txt/movie.txt?type=attachment";

        URL url = new URL(path);

        Scanner scanner = new Scanner(url.openStream());
        ArrayList<Movie> movieList = new ArrayList<>();

        while(true) {
            try {
                String str = scanner.nextLine();

                System.out.println(str);

                String[] arr = str.split(",");
                movieList.add(
                        new Movie(arr[0], Integer.parseInt(arr[1])));
            }catch(Exception e){
                break;
            }
        }//end while
        return movieList;
    }
}
