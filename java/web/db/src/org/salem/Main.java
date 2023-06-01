package org.salem;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args)throws Exception {

        String url = "jdbc:oracle:thin:@10.10.10.80:1521:XE";
        String user = "system";
        String pw = "12345678";

        //step1 loading driver
        Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println(clz);

        for(int i=0; i<20; i++){
            new Thread(()->{
                try{
                    //step2 connect db with protocol
                    Connection connection = DriverManager.getConnection(url,user,pw);
                    System.out.println(connection);

//                    Thread.sleep(5000);

                    connection.close();
                    System.out.println("close.......................");

                }catch (Exception e){
                    e.printStackTrace();
                }//end catch
            }).start();
        }//end for
    }//end main
}//end class
