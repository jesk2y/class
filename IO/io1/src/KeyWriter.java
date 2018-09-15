import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyWriter {

    //bad code
    public static void main(String[] args)throws Exception {
        // 경로에 파일 없을수도 있어서 try 씌워줘야하는데 귀찮으니까 throws
        InputStream in = System.in;
        OutputStream out = new FileOutputStream("C:\\zzz\\test.txt");

        System.out.println("한글 넣어봐");
        for(int i=0; i<100; i++){   // 이거는 간단하게 테스트해보려고 계속 반복되게 만든것
            int data = in.read();
            System.out.println(data);
            out.write(data);    // 이거 안쓰면 test 파일에 기록이 안됨
        }
        in.close();
        out.close();
    }
}
