对hs数据库的表test进行查询所有的数据，这里需要注意的是利用while循环进行查询判断

```java
package Advanced.JDBC;

import java.sql.*;

public class Demo6JdbcSelect {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //查询sql语句
            String sql="select * from test";
            conn=DriverManager.getConnection("jdbc:mysql:///hs","root","123456");
            stmt=conn.createStatement();
            //查询
            rs=stmt.executeQuery(sql);
            //让游标向下移动一行,一直到末尾判断没有数据返回false结束循环为止
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString("name");
                double price=rs.getDouble( 3);
                System.out.println("id:"+id+",name:"+name+",price:"+price);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
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
    }
}
```

成功查询截图:

![](https://picture.hs-vae.com/jdbc查询语句.png)