package movie;

public class Main {

    public static void main(String[] args) throws Exception{

        MovieLoader loader = new KoreanMovieLoader();

        MovieUI ui = new MovieUI(loader);

        ui.printList();
    }
}