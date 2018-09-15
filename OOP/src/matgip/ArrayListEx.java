package matgip;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        //create(insert)
        list.add("AAA");
        list.add("AAB");
        list.add("AAC");
        System.out.println(list);

        //read
        System.out.println(list.get(2));
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);

        //update
        list.set(0,"zzz");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.stream().forEach(x-> System.out.println(x));

        Collections.shuffle(list);;
        System.out.println(list);


    }
}
