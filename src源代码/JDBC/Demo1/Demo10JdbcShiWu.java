package com.hs_vae.JDBC.Demo1;

import com.hs_vae.JDBC.Util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
      事务管理，
      做一个交易事务
      在hs数据库中,account表中对 name = hs 加price+500块钱, name = nj 减price - 500块钱
 */
public class Demo10JdbcShiWu {
    public static void main(String[] args) {
        DBUtils db=new DBUtils();
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        try {
            //1.获取连接
            conn=db.getConnection();
            //2.获取事务自动提交状态
            boolean autoCommit=conn.getAutoCommit();
            System.out.println("事务自动提交状态:"+autoCommit);
            if(autoCommit){
                //关闭自动提交,开启事务
                conn.setAutoCommit(false);
            }
            //2.定义sql语句
            String sql1="update account set price = price + ? where id = ?";
            String sql2="update account set price = price - ? where id = ?";
            //3..获取执行sql对象
            pstmt1=conn.prepareStatement(sql1);
            pstmt2=conn.prepareStatement(sql2);
            //4.设置参数,对id=1的price加500,对id=2的price减500
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            //5.执行sql,对price进行增减
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            //6.在所有sql执行完后,提交事务
            conn.commit();
            //7.恢复原有事务提交状态
            conn.setAutoCommit(autoCommit);
        } catch (Exception e) {   //注意:这里抓的是Exception
            e.printStackTrace();
            try {
                //回滚事务
                if(conn!=null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            //关闭连接,释放资源
           db.closeAll();
        }
    }
}
