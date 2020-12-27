package com.hs_vae.JDBC.Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4JdbcDelete {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql="delete from test where id =6";
            conn= DriverManager.getConnection("jdbc:mysql:///hs","root","hs101544");
            stmt=conn.createStatement();
            int count=stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0){
                System.out.println("删除该数据成功");
            }else {
                System.out.println("删除该数据失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
