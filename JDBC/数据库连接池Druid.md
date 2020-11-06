<!-- toc -->

### 1.概念

​    **其实就是一个容器 (集合)，存放数据库连接的容器。当系统初始化好后，容器被创建，容器中会申请一些连接 对象，当用户来访问数据库时，从容器中获取连接对象，用户访问完之后，会将连接对象归还给容器。**

### 2.好处

1. 节约资源
2. 用户访问高效

### 3.实现

​    标准接口：javax.sql.DataSource

1. 方法：
   * 获取连接：getConnection()
   * 归还连接：Connection.close()。如果连接对象Connection是从连接池中获取的，那么调用Connection.close()方法，则不会再关闭连接了。而是归还连接
2. 一般我们不去实现它，有数据库厂商来实现
   * Druid：数据库连接池实现技术，由阿里巴巴提供的，Druid是目前最好的数据库连接池，在功能、性能、扩展性方面，都超过其他数据库连接池

### 4.Druid：数据库连接池实现技术

步骤:

1. 导入jar包：druid-1.0.9.jar
2. 定义配置文件：druid.properties
3. 加载配置文件：利用Properties中load方法
4. 获取数据库连接池对象：通过工厂商来获取  DruidDataSourceFactory
5. 获取连接：getConnection

定义工具类：

1. 定义一个类 JDBCDruidUtils
2. 提供静态代码块加载配置文件，初始化连接池对象
3. 提供三个方法
   * 获取连接方法：通过数据库连接池获取连接
   * 释放资源
   * 获取连接池的方法

### 5.JDBCDruidUtils 连接池工具类

```java
package Advanced.JDBC.Util;

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
            Properties pro=new Properties();            pro.load(JDBCDruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
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

```

### 6.使用

```java
package Advanced.JDBC.Druid;

import Advanced.JDBC.Util.JDBCDruidUtils;

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

//输出结果
1
```

7.执行后的数据库

![](https://picture.hs-vae.com/连接池执行后的数据库png)

插入成功，多了一行 id =3  name=vae  price=2000