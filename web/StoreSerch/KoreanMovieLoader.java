package org.zerock;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class KoreanMovieLoader implements MovieLoader {
    @Override
    public ArrayList<Movie> getList() throws Exception {

        Scanner scanner =
                new Scanner(new FileInputStream("C:\\zzz\\movie.txt"));

        ArrayList<Movie> movieList = new ArrayList<>();

        while(true) {
            try {
                String str = scanner.nextLine();
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
