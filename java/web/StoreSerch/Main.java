package org.zerock;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception{

        MovieLoader loader = new KoreanMovieLoader();

        MovieUI ui = new MovieUI(loader);

        ui.printList();
    }
}
