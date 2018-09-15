package json;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.Movie;

import java.io.DataInputStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.List;

public class DataClient {

    //bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1",7777);

        DataInputStream din
                = new DataInputStream(socket.getInputStream());

        // = InputStream in = socket.getInputStream();
        //   DataOutputStream din = new DataOutputStream(in)

        String msg = din.readUTF(); // UTF-8 인코딩을 사용해서 문자열을 읽는다
        System.out.println(msg);

        Gson gson = new Gson(); //Gson 정의

        Type listType = new TypeToken<List<Movie>>(){ }.getType();
        List<Movie> movieList = gson.fromJson(msg, listType);
        // List는 인터페이스, ArrayList는 List에 상속된 클래스
        /*
            JAVA에서 GSON으로 리스트 형태의 데이터를 변환하는 경우
            아래와 같이 Type 인스턴스를 생성해서 적용해줘야 컴파일 에러가 나지 않는다

            Type type = new TypeToken<List<PrvtMappingInfo>>() {}.getType();
            gson.toJson(mappingInfoList, type));
            gson.fromJson(jsonString, type);
         */
        System.out.println(movieList);

        for(Movie m:movieList){
            System.out.println(m);
        }

        din.close();
        socket.close();

    }
}