在这里要注意的是异常问题，抛出在这里不太合适，应该选择抓异常进行抛出try catch

在id = 6 那一行 插入 name = 'jay'

```java
package Advanced.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2JdbcInsert {
    public static void main(String[] args) {
        /*
           因为要在finally中释放资源,但是stmt和conn对象在try作用域里,
           相当于局部变量,所以要提升作用域放到try外边,成为成员变量并且赋值为null
         */
        Statement stmt=null;
        Connection conn=null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql="insert into test values(5,'jay')";
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
    }
}
```

最终结果截图:

没有插入之前的workbench

![](https://picture.hs-vae.com/JDBCDemo2png)

运行run成功后

可以看到已经成功插入了数据，workbench中插入了一条hs数据库中test表  id=6,name='jay'

![](https://picture.hs-vae.com/Demo2插入成功.png)