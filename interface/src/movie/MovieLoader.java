package movie;

import java.util.ArrayList;

public interface MovieLoader {

    ArrayList<Movie> getList()throws Exception;
}