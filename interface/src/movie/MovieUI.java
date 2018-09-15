package movie;

import java.util.ArrayList;
import java.util.Collections;

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