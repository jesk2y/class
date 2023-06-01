package json;

import com.google.gson.Gson;
import domain.Movie;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DataServer {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("READY");

        Socket socket = serverSocket.accept();
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        /*
        FileInputStream, FileOutputStream 같은건 byte[] 단위의 데이터만 입/출력을 할수있음
        하지만 DataStream은 자바 기본 자료형(char,int,long 등) 으로 데이터를 입력하고 출력할 수 있다

        * */

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++){

            Movie movie = new Movie();
            movie.setTitle("다크 나이트" + i);
            movie.setDirector("크리스토퍼 놀란");
            movie.setPop(1300);
            movie.setScore(4.7);
            movieArrayList.add(movie);
        }

        Gson gson = new Gson(); //Gson 정의
        String str = gson.toJson(movieArrayList);   //gson을 사용해서 json타입으로 변환시킴
        dos.writeUTF(str);
        //writeUTF -> DataOutputStream
        // UTF-8 인코딩을 사용해서 문자열을 출력한다

        dos.close();
        socket.close();
        serverSocket.close();

    }
}