package restfinder;

import java.util.Arrays;

public class Restaurant {

    String name;
    String[] menu;

    public Restaurant(String name, String[] menu) {
        this.name = name;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + Arrays.toString(menu) +
                '}';
    }

    public boolean isSell(String menuname){
        boolean result = false ;
        for (String menu: this.menu) {
            if (menu.contains(menuname)){
                result = true;
            }
        }

        return result;
    }

}