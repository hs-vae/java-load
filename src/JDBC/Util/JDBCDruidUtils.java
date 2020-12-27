package com.hs_vae.JDBC.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDruidUtils {
    //1.定义成员变量 DataSource
    private static DataSource ds;

    //2.静态代码块
    static {
        try {
            //1.加载配置文件
            Properties pro=new Properties();
            pro.load(JDBCDruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取DataSource
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.获取连接的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    //4.释放资源
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }
    //方法重载形式
    public static void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
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

    //5.获取连接池方法
    public static DataSource getDataSource(){
        return ds;
    }

}
