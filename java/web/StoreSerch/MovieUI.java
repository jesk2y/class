package org.zerock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MovieUI {

    MovieLoader loader;

    public MovieUI(MovieLoader loader) {
        this.loader = loader;
    }

    public void printList()throws Exception{
        ArrayList<Movie> list = loader.getList();

        Collections.sort(list);

        for (Movie movie:list ) {
            System.out.println(movie);
        }

    }

}
