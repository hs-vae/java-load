<!-- toc -->

在写JDBC代码中有很多代码是重复的

比如注册驱动获取连接、释放资源等

我们可以抽取一个DBUtils工具类进行简化代码

减少重复的代码

使用时只需要导包，调用工具类的方法

## 建立 jdbc.properties 配置文件

注意 ： 在获取连接对象时候在 src 目录建立一个  jdbc.properties 配置文件

![](https://picture.hs-vae.com/配置.png)

## 建立 Config 类：读取属性文件中的配置信息

```java
package Experiment.Demo2;

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

```java
package Experiment.Demo2;

import java.sql.*;

public class DBUtils {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement ptmt=null;

    // 2.获取连接
   public Connection getConnection() throws SQLException {
       String url=Config.getValue("url");
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
    public ResultSet excuteQuery(String preparedSql , String[] param){
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
    public int excuteUpdate(String preparedSql , String[] param){
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

下面给出一个查询语句例子，看看优化的效果

## 使用DBUtils工具类

这里代码变得简化了很多，是不是比以前看的更舒服了

```java
package Experiment.Demo2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1A {
    public static void main(String[] args) {
          DBUtils db=new DBUtils();
          String sql="select * from account";
        try {
            db.getConnection();
            //查询语句,不用写数据String类的数组param
            ResultSet rs = db.excuteQuery(sql, null);
            while (rs.next()){
                System.out.println(rs.getString(2)+rs.getDouble(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeAll();
        }
    }
}

//查询后的输出结果
----------查询后的数据----------
1	hs	1000.0
2	nj	1000.0
3	vae	2000.0
------------------------------
```

