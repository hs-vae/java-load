<!-- toc -->

# 三个准备工作

## jdbc.properties 配置文件

在src目录下创建一个jdbc.properties文件

里面包含(根据个人数据库用户和密码不同进行修改,我的jdbc驱动是8.0.22版本,所以driver这样写):

```java
url=jdbc:mysql:///mobile_shop
user=root
password=123456
driver=com.mysql.cj.jdbc.Driver
```

## Config 类:加载配置文件

```java
package Advanced.JDBC.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//配置类Config
public class Config {
    private static Properties p=null;
    static {
        try {
            //加载配置文件
            p=new Properties();
            p.load(new FileInputStream("src/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // 获取键对应的值
    public static String getValue(String key){
        return p.get(key).toString();
    }
}

```

## DBUtils工具类

* 包含获取连接的方法getConnection()
* 包含释放资源的方法closeAll()
* 包含执行SQL语句中查询的executeQuery(String preparedSql , String[] param)方法
* 包含执行SQL语句中"增、删、改"的executeUpdate(String preparedSql , String[] param)方法

```java
package Advanced.JDBC.Util;

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

```

