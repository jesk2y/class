package org.zerock.searcher;

import org.zerock.domain.Store;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbstractSearcher {

    ArrayList<Store> storeList;
    Scanner scanner;

    AbstractSearcher()throws Exception{
        storeList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void load(String fileName)throws Exception{

        System.out.println("load file " + fileName );
        Scanner scanner = new Scanner(new FileInputStream(fileName), "UTF-8");
        while(true){
            try{
                String str = scanner.nextLine();
                System.out.println(str);

                String[] arr = str.split(",");
                Store obj = new Store();
                obj.setName(arr[0]);
                obj.setLat(Double.parseDouble(arr[1]));
                obj.setLng(Double.parseDouble(arr[2]));
                obj.setDesc(arr[3]);

                storeList.add(obj);

            }catch(Exception e){
                break;
            }//end catch
        }//end while

    }

    public abstract ArrayList<Store> search();


}
