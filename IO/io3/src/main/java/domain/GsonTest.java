package domain;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GsonTest {
    //bad code
    public static void main(String[] args)throws Exception {

        Movie movie = new Movie();

        ArrayList<Movie> list = new ArrayList<>();

        for(int i=0; i<4; i++){
            movie.setTitle("그래비티");
            movie.setDirector("알폰소 쿠아론");
            movie.setPop(231);
            movie.setScore(4.0);
            list.add(movie);
        }

        Gson gson = new Gson();

        String str = gson.toJson(movie);
        System.out.println(str);
    }
}
