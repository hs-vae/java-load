<!-- toc -->

# 任务C：编写存储过程查询出九月份有登陆过本系统会员信息要求查询出具体的会员名称和登陆时间

## 存储过程selectUsers()

```sql
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectUsers`(IN year int,IN month int)
BEGIN
	#Routine body goes here...
SELECT Uname,Lastlogin from ms_memer WHERE YEAR(Lastlogin)=year And MONTH(Lastlogin)=month;
END
```

## 实现代码

```java
package Experiment.Demo2.Demo1;

import Advanced.JDBC.Util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    要求:编写存储过程查询出九月份有登陆过本系统会员信息要求查询出具体的会员名称和登陆时间
 */
public class Demo3C {
    public static void main(String[] args) {
        DBUtils db=new DBUtils();
        try {
            db.getConnection();
            ResultSet rs=db.executeQuery("call selectUsers(2020,09)",null);
            System.out.println("---------9月份登录过本系统的会员信息-----------");
            System.out.println("    "+"会员名称"+"     "+"最后一次登录时间");
            while (rs.next()){
                System.out.println(rs.getRow()+":"+"\t"
                        +rs.getString(1)+"\t"
                        +rs.getString(2)+"\t");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeAll();
        }
    }
}

```

## 查询结果

![image-20201224193111475](https://picture.hs-vae.com/image-20201224193111475.png)






