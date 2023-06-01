package jr.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopList{

    private List<Shop> shopList;

    public ShopList(){

        shopList = new ArrayList<>();
        shopList.add(new Shop("Hun-s","casual","http://hun-s.com/","90,600", "431"));
        shopList.add(new Shop("SuperStar I","casual","http://www.superstari.co.kr/","42,400","263"));
        shopList.add(new Shop("Jogun Shop","casual","http://www.jogunshop.com/","24,300","171"));
        shopList.add(new Shop("Yurue","casual","http://yurue.co.kr/","11,600","245"));
        shopList.add(new Shop("EuroHomme","dendy","http://eurohomme.co.kr/","5,360","78"));
        shopList.add(new Shop("Golden Bo2","dendy","http://www.goldenbo2.com/","4.870","40"));
        shopList.add(new Shop("Byther","uniq","http://www.byther.kr","6,940","72"));
        shopList.add(new Shop("EverFree","uniq","http://everfree.co.kr","5,440","60"));
        shopList.add(new Shop("Disco-J","uniq","http://www.disco-j.co.kr/","4,650","54"));
    }



    public List<Shop> getShop(final String key) {
        System.out.println("getShop............." + key);

        System.out.println(shopList);

        return shopList.stream().filter(obj -> {

            System.out.println(obj);
            boolean result = obj.getStyle().equals(key);
            System.out.println(result);
            System.out.println("---------------------");

            return result;

        } ).collect(Collectors.toList());

    }
}
