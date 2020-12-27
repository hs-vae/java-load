package com.hs_vae.JDBC.Util;

import java.sql.*;


public class DBUtils {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement ptmt=null;

    // 2.获取连接
   public Connection getConnection() throws SQLException {
       String url= Config.getValue("url");
       String user=Config.getValue("user");
       String password=Config.getValue("password");
       String driver=Config.getValue("driver");
       try {
           Class.forName(driver);
           conn=DriverManager.getConnection(url,user,password);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       return conn;
   }
    // 3.释放资源
    public  void closeAll(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ptmt!=null){
            try {
                ptmt.close();
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
    // 4.执行SQL语句,可以进行查询
    public ResultSet executeQuery(String preparedSql , String[] param){
        try {
            // 创建执行sql的PrepareStatement对象
            ptmt=conn.prepareStatement(preparedSql);
            if(param!=null){
                for (int i = 0; i < param.length; i++) {
                    //为预编译的sql设置参数,这里注意起点的编号是1,和数组索引不一样，所以要加1
                    ptmt.setString(i+1,param[i]);
                }
            }
            // 获取执行sql对象,执行sql语句
            rs=ptmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }
    // 5.执行SQL语句,可以进行增,删,改的操作
    public int executeUpdate(String preparedSql , String[] param){
        int count=0;
        try {
            // 创建执行sql的PrepareStatement对象
            ptmt=conn.prepareStatement(preparedSql);
            if(param!=null){
                for (int i = 0; i < param.length; i++) {
                    //为预编译的sql设置参数,这里注意起点的编号是1,和数组索引不一样，所以要加1
                    ptmt.setString(i+1,param[i]);
                }
            }
            count=ptmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
