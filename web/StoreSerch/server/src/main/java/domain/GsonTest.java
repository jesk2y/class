package domain;

import com.google.gson.Gson;

public class GsonTest {

    //bad code
    public static void main(String[] args)throws Exception {

        Movie movie = new Movie();
        movie.setTitle("다크 나이트");
        movie.setDirector("크리스토퍼 놀란");
        movie.setPop(1300);
        movie.setScore(4.7);

        Gson gson = new Gson();

        String str = gson.toJson( movie);

        System.out.println(str);

    }
}
