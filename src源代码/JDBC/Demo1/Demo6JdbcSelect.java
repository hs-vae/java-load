package com.hs_vae.JDBC.Demo1;

import java.sql.*;

public class Demo6JdbcSelect {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //查询sql语句
            String sql="select * from test";
            conn=DriverManager.getConnection("jdbc:mysql:///hs","root","hs101544");
            stmt=conn.createStatement();
            //查询
            rs=stmt.executeQuery(sql);
            //让游标向下移动一行,一直到末尾判断没有数据返回false结束循环为止
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString("name");
                double price=rs.getDouble( 3);
                System.out.println("id:"+id+"-----name:"+name+"-----price:"+price);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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