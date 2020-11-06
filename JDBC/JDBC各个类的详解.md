<!-- toc -->

步骤:

```java
package Advanced.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1Jdbc {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包:mysql-connector-java-8.0.22
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/hs","root","123456");
        //4.定义sql语句
        String sql="update test set name='yg' where id=1";
        //5.获取执行sql的对象Statement
        Statement stmt=conn.createStatement();
        //6.执行sql
        int count=stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}

//输出结果
1
同时数据库id为1的名字变成了yg
```

详解各个对象:

## 1.  DriverManager :  驱动管理对象

> 功能

​         1.  注册驱动: 告诉程序该使用哪一个jar包

​           static  void  registerDriver(Driver   driver) :  注册与给定的驱动程序 DriverManager

​           写代码使用: Class.forName("com.mysql.jdbc.cj.Driver") ;

​           通过查看源码发现: 在com.mysql.jdbc.cj.Driver类中存在静态代码块     

```java
static {
    try {
        DriverManager.registerDriver(new Driver());
    } catch (SQLException var1) {
        throw new RuntimeException("Can't register driver!");
    }
}
```

​           注意:mysql 5之后的驱动jar包可以省略注册驱动的步骤

​         2.  获取数据库连接:

​            *   方法 : static  Connection   getConnecttion(String url, String user ,  String  password)

​            *   参数 : 

​                   url :  指定连接的路径     jdbc:mysql://ip地址(域名):端口号/数据库名称

​                             如果连接的是本机mysql服务器端口号为3306,则可以简写:jdbc:mysql:///数据库名称

​                   user:  用户名                  root

​                   password :  密码           **..     

## 2.  Connection : 数据库连接对象

> 功能

1. 获取执行sql的对象

   * Statement   createStatement()

   * PreparedStatement    prepareStatement(String  sql)

   2. 管理事务 
      * 开启事务: setAutoCommit(boolean   autoCommit) :  调用该方法设置参数为false , 即就开启事务
      * 提交事务: commit()
      * 回滚事务: rollback()

## 3.  Statement :  执行sql的对象

> 执行sql

1. boolean   execute (String  sql) : 可以执行任意的sql
2. int  executeUpdate(String  sql) :  执行DML (insert，update，delete)语句、DDL(create，alter，drop)语句
   * 注意：返回值: 影响的行数，可以通过这个影响的行数判断DML语句是否执行成功(返回值>0)，反之失败 
3. ResultSet   executeQuery(String  sql) :  执行DQL( select )语句   

> 练习

1. test表  添加一条记录  

2. test表  修改记录

3. test表  删除一条记录

4. 代码:(以添加一条记录为例)

   ```java
   Statement stmt=null;
           Connection conn=null;
           try {
               //1.注册驱动
               Class.forName("com.mysql.cj.jdbc.Driver");
               //2.定义sql
               String sql="insert into test values(6,'jay')";
               //3.获取Connection对象
               conn= DriverManager.getConnection("jdbc:mysql:///hs","root","123456");
               //4.获取执行sql的对象  Statement
               stmt=conn.createStatement();
               //5.执行sql
               int count = stmt.executeUpdate(sql);   //影响的行数
               //6.处理结果
               System.out.println(count);
               if(count>0){
                   System.out.println("插入数据成功");
               }else {
                   System.out.println("插入数据失败");
               }
           } catch (ClassNotFoundException | SQLException e) {
               e.printStackTrace();
           }finally {
               /*
                   如果这个conn连接里面比如密码错了，那么stmt那里就执行不到，会掉到catch里面
                   这时候stmt还是null值，这时候stmt.close();会产生空指针异常
                   所以要在这里对stmt和conn进行if判断是否为空,
                      如果为空那没必要释放资源
                      如果不为空那么会产生内存垃圾文件就要释放资源
                */
               //7.释放资源
               if(stmt!=null){
                   try {
                       stmt.close();
                   } catch (SQLException throwables) {
                       throwables.printStackTrace();
                   }
               }
               if (conn!=null){
                   try {
                       conn.close();
                   } catch (SQLException throwables) {
                       throwables.printStackTrace();
                   }
               }
           }                
   ```

## 4.ResultSet :  结果集对象 

*   boolean next() :  游标向下移动一行 , 判断当前行是否是最后一行末尾(是否有数据)

*   getXxx(参数) : 获取数据

  * Xxx : 代表数据类型  如 :  int getInt() , Strng getString() 
  * 参数 : 
    1. int : 代表列的编号，从1开始，如：getString(1)
    2. String：代表列名称。如：getDouble("price")

* 注意:

  * 使用步骤:

    1. 游标向下移动一行
    2. 判断是否有数据
    3. 获取数据

       //循环判断游标是否是最后一行末尾

    ```java
    //让游标向下移动一行，一直到末尾判断没有数据返回false结束循环为止
       while (rs.next()) {
        int id=rs.getInt(1);
        String name=rs.getString("name");
        double price=rs.getDouble(3);
        System.out.println("id:"+id+",name:"+name+",price:"+price);
    }
    ```


## 5.PreparedStatement : 执行sql对象

1. SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
2. 解决SQL注入问题：使用PreparedStatement对象来解决
3. 预编译的SQL：参数使用 ？ 问号作为占位符
4. 步骤:
   1. 导入驱动jar包 mysql-connector-java-8.0.22.jar
   2. 注册驱动
   3. 获取数据库连接对象 Connection
   4. 定义sql：
      * 注意：sql的参数使用？作为占位符。例如：select * from where username = ?
   5. 获取执行sql语句的对象 PrepareStatement
      * 注意：这里Connection.preprareStatement(String sql) 要写参数sql
   6. 给 ？ 赋值
      * 方法：setXxx(参数1，参数2)
        * 参数1：？的位置编号，从1开始
        * 参数2：？的值
        * 例如：setString(1,username)
   7. 执行sql，接受返回结果，不需要传递sql语句
   8. 处理结果
   9. 释放资源
