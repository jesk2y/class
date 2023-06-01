import org.zerock.io2.domain.Movie;

import java.lang.reflect.Field;

public class BreakPrivate {

    public static void main(String[] args) throws Exception {

        Movie obj = new Movie("옹박","A");

        Class clz = obj.getClass();

        Field field = clz.getDeclaredField("genre");

        field.setAccessible(true);
        field.set(obj,"M");
        System.out.println(obj);

    }

}
