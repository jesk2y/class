package org.zerock.io2;

import org.zerock.io2.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMaker implements MsgMaker{

    private List<Movie> movieList;

    public MovieMaker(){
        movieList = new ArrayList<>();
        movieList.add(new Movie("공작","D"));
        movieList.add(new Movie("목격자","T"));
        movieList.add(new Movie("올드보이","A"));
        movieList.add(new Movie("번지점프","D"));
        movieList.add(new Movie("아바타","A"));
        movieList.add(new Movie("쇼생크탈출","D"));
        movieList.add(new Movie("터미네이터","A"));
        movieList.add(new Movie("월터의 상상","D"));
    }

    @Override
    public String[] getMsg(String key) {

        List<String> list = new ArrayList<>();

        for (Movie m:movieList) {

            boolean result = m.checkGenre(key);

            if(result){
                list.add(m.getTitle());
            }

        }

        return list.toArray(new String[0]);
    }
}
