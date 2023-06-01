package org.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class QueryExecutor implements Executor{

    protected Connection con = null;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;

    public void executeAll(){

        try {
            makeConnection();
            doJob();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            closeAll();
        }
    }

    private void  makeConnection()throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");  //메모리에 로드
        con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.83:1521:XE",
                "jsk","12345678");
    }

    private void closeAll(){
        System.out.println("close All...." + con);
        if(rs != null) {
            try { rs.close(); }catch(Exception e){}
        }
        if(stmt != null) {
            try { stmt.close(); }catch(Exception e){}
        }
        if(con != null) {
            try { con.close(); }catch(Exception e){}
        }
    }

}