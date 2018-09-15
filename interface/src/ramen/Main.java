package ramen;

public class Main {
    public static void main(String[] args) {
        Ramen[] arr = {new SoupRamen(), new BibimRamen(), new ZazangRamen()};

        for(Ramen r: arr){
            r.bolingWater();
            r.cook();
            r.dish();
        }

    }
}
