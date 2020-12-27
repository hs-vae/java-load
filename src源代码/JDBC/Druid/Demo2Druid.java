package com.hs_vae.JDBC.Druid;

import com.hs_vae.JDBC.Util.JDBCDruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
     利用JDBCDruidUtils工具类进行插入一条语句
 */
public class Demo2Druid {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //1.获取连接
            conn= JDBCDruidUtils.getConnection();
            //2.定义sql语句
            String sql="insert into account values(null,?,?)";
            //3.获取pstmt对象
            pstmt=conn.prepareStatement(sql);
            //4.给占位符?赋值
            pstmt.setString(1,"vae");
            pstmt.setDouble(2,2000);
            //5.执行sql
            int count=pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCDruidUtils.close(pstmt,conn);
        }
    }


}
