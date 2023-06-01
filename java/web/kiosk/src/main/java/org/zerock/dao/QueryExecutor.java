package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class QueryExecutor implements Executor {
    protected Connection con = null;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;

    public void executeAll(){
        try{
            makeConnection();
            doJob();
        }catch (Exception e){e.printStackTrace();
            System.out.println(e.getMessage());}finally {closeAll();}
    }

    public void makeConnection()throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
//        con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.93:1521:XE",
//                "zziggu","12345678");
        con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.83:1521:XE",
                "jsk","12345678");
    }

    public void closeAll() {
        System.out.println("close,,,,,,,,,,,,,,,,");
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
            }
        }

    }
}
