import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    //bad code
    public static void main(String[] args)throws Exception {

        InputStream in = new FileInputStream("C:\\zzz\\sample.txt");
        OutputStream out = new FileOutputStream("C:\\zzz\\sample2.txt");

        byte[] buffer = new byte[5];

        long start = System.currentTimeMillis();
        //read write
        while(true){
            int count = in.read(buffer); // buffer만큼의 값을 읽어냄(없으면 1바이트씩 읽어냄)
            System.out.println("COUNT: " + count);
            if(count == -1){ break; }
            out.write(buffer,0,count);
            //count만큼의 값을 읽고 sample2에 씀. 만약 count대신 5 쓰면 abc....mnj < j가 추가로 출력됨(루프돌때마다 5씩 읽어내므로)
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        in.close();
        out.close();

    }
}
