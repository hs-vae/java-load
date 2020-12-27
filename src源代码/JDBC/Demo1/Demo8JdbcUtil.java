package com.hs_vae.JDBC.Demo1;

import com.hs_vae.JDBC.Util.JDBCUtils;

import java.sql.*;

public class Demo8JdbcUtil {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //1.利用工具类Utils优化,直接调用静态方法,注意这里返回值是Connection类型
            conn =JDBCUtils.getConnection();
            //2.定义sql语句
            String sql="select * from test";
            //3.创建执行sql对象
            stmt=conn.createStatement();
            //4.获取执行sql对象
            rs=stmt.executeQuery(sql);
            //5.查询,让游标向下移动一行,一直到末尾判断没有数据返回false结束循环为止
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString("name");
                double price=rs.getDouble( 3);
                System.out.println("id:"+id+"-----name:"+name+"-----price:"+price);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //调用JDBCUtils工具类中的close静态方法
            JDBCUtils.close(rs,stmt,conn);
        }
    }
}
