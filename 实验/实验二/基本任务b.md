<!-- toc -->

# 编写存储过程实现会员信息的删除，要求删除9月1日以前注册的会员信息(自行准备好测试数据)

建议先把数据先导出来备份一下，避免出错数据缺失

## 删除前的ms_memer表

![](https://picture.hs-vae.com/插入100条数据.png)

## 实现代码

```java
package Experiment.Demo2;

import Advanced.JDBC.Util.DBUtils;

import java.sql.SQLException;

public class Demo2B {
    public static void main(String[] args) {
        DBUtils db=new DBUtils();
        try {
            //获取连接
            db.getConnection();
            //定义sql语句,要求删除9月1日之前注册的会员信息
            String sql="delete from ms_memer where Regtime<? ";
            db.executeUpdate(sql,new String[]{"2020-08-31 23:59:59"});
            System.out.println("已成功删除9月1日前注册的会员信息");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeAll();
        }
    }
}

//输出结果
已成功删除9月1日前注册的会员信息

Process finished with exit code 0
```

## 删除后的ms_memer表

![](https://picture.hs-vae.com/删除后的数据库.png)

删除成功！留下来的都是9月以后注册的会员信息