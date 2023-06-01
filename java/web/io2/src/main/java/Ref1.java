import java.lang.reflect.Method;
import java.util.Scanner;

public class Ref1 {

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);

        System.out.println("클래스 이름 ");
        String className ="org.zerock.io2." + scanner.nextLine();

        Class clz = Class.forName(className);

        Class clzzz = void.class;

        Method method = clz.getDeclaredMethod("getMsg", String.class);

        Object obj = clz.newInstance();

        System.out.println(obj);

        System.out.println("파라미터 ");
        System.out.println(method.invoke(obj,scanner.nextLine()));
    }
}
