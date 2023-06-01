package restfinder;

public class RestaurantFinder {
    Restaurant[] restaurant;


    public RestaurantFinder(Restaurant[] restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant[] findByMenu(String menuname) {

        Restaurant[] result = new Restaurant[10];

        int i = 0;
        for (; i < this.restaurant.length; i++) {
            Restaurant res = this.restaurant[i];

            if(res.isSell(menuname)){
                result[i]=res;
            }
        }


        return result;
    }
}