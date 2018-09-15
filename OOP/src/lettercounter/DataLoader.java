package lettercounter;

import java.io.File;
import java.util.Scanner;

public class DataLoader {

    public String loadData(String fileName) {

        StringBuffer buffer = new StringBuffer();

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (true) {
                buffer.append(scanner.nextLine().toUpperCase());

            }//end while
        }catch(Exception e){

        }
        return buffer.toString();
    }

}