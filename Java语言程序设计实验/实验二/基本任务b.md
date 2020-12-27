<!-- toc -->

# 编写存储过程实现会员信息的删除，要求删除9月1日以前注册的会员信息(自行准备好测试数据)

建议先把数据先导出来备份一下，避免出错数据缺失

## 删除前的ms_memer表

![](https://picture.hs-vae.com/image-20201224190737759.png)

## 存储函数deleteUsers()

```sql
CREATE DEFINER=`root`@`localhost` FUNCTION `deleteUsers`() RETURNS int(11)
    READS SQL DATA
BEGIN
	#Routine body goes here...
#定义一个初始值i,用来记录查询9月1日注册的信息个数

	DECLARE i int DEFAULT 1;

	#执行查询9月1号之前注册的会员信息的个数并赋值给i

	SELECT COUNT(*) INTO i FROM ms_memer WHERE YEAR(ms_memer.Regtime)=2020 AND MONTH(ms_memer.Regtime)<9;

	#执行删除9月1号之前注册的会员信息

	DELETE FROM ms_memer WHERE YEAR(ms_memer.Regtime)=2020 AND MONTH(ms_memer.Regtime)<9;

	RETURN i;
	RETURN 0;
END
```

## 实现代码

```java
package Experiment.Demo2.Demo1;

import Experiment.Demo2.Demo2.db.DBUtil;

import java.sql.SQLException;

public class Demo2B {
    public static void main(String[] args) {
        DBUtil db=new DBUtil();
        try {
            //获取连接
            db.getConnection();
            //定义sql语句,要求删除9月1日之前注册的会员信息
            db.executeQuery("select deleteUsers()",null);
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

![image-20201224193212774](https://picture.hs-vae.com/image-20201224193212774.png)

删除成功！留下来的都是9月以后注册的会员信息