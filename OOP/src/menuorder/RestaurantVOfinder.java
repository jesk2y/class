package menuorder;

public class RestaurantVOfinder {
    RestaurantVO[] restaurant;

    public RestaurantVOfinder(RestaurantVO[] rvo) {
        this.restaurant = rvo;
    }

    public RestaurantVO storeReturn(String str) {
        RestaurantVO result = null;

        for (RestaurantVO arr : restaurant) {
            if (arr.menu.contains(str)) {
                System.out.println(arr.store + " : " + arr.menu);
            }
        }
        return result;
    }
}