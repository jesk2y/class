import com.google.gson.Gson;
import domain.Movie;

import java.io.DataInputStream;
import java.net.Socket;

public class DataClient {

    //bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1",7777);

        DataInputStream din
                = new DataInputStream(socket.getInputStream());

        String msg = din.readUTF();
        System.out.println(msg);

        Gson gson = new Gson();

        Movie movie = gson.fromJson(msg, Movie.class);

        System.out.println(movie);

        din.close();
        socket.close();

    }
}
