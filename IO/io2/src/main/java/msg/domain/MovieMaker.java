package msg.domain;

import msg.MsgMaker;

import java.util.ArrayList;
import java.util.List;

public class MovieMaker implements MsgMaker {

    private List<Movie> movieList;

    public MovieMaker(){
        movieList = new ArrayList<>();
        movieList.add(new Movie("공작","D,T"));
        movieList.add(new Movie("목격자","T"));
        movieList.add(new Movie("올드보이","A,T"));
        movieList.add(new Movie("번지점프","A, D"));
        movieList.add(new Movie("아바타","A"));
        movieList.add(new Movie("쇼생크탈출","D,T"));
        movieList.add(new Movie("터미네이터","A"));
        movieList.add(new Movie("월터의 상상","D"));
    }

    @Override
    public String[] getMsg(String key) {

        List<String> list = new ArrayList<>();  //스트링값으로만 있는 배열(이름 출력할거므로 배열로 안이루어짐)

        for (Movie m:movieList) {

            boolean result = m.checkGenre(key); //클라이언트에서 서버로 보낸 str(장르, 요일값)

            if(result){
                list.add(m.getTitle());
            }

        }

        return list.toArray(new String[0]);
    }
}