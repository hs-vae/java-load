<!-- toc -->

# 任务：编写存储过程实现会员信息数据的插入，功能测试时可以插入100条会员信息数据

## 在Navicat(Wine 环境下)中建立一个ms_memer表

![](https://picture.hs-vae.com/image-20201224184104249.png)

## 存储过程addUsers()

```sql
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUsers`(IN i  int)
BEGIN
	#Routine body goes here...
DECLARE uname VARCHAR(50) DEFAULT 'hs';
	DECLARE upwd VARCHAR(50)  DEFAULT '123456';
	DECLARE email VARCHAR(50) DEFAULT '@qq.com';
    DECLARE sex SMALLINT(6) ;
	DECLARE time VARCHAR(50) DEFAULT NOW();
	DECLARE mark int DEFAULT 1;	
	DECLARE image VARCHAR(500) DEFAULT 'vae';
	#设置while循环,只当mark等于给定的i为止
	WHILE mark<=i DO
	#设置登陆时间
	SET time = CONCAT('2020-',FLOOR(1+RAND()*12),'-',FLOOR(1+RAND()*30),' ',FLOOR(RAND()*23),':',FLOOR(RAND()*59),':',FLOOR(RAND()*59));
	#插入信息#
	#前五十个为男,后五十个为女
	IF mark%2=0 THEN
	SET sex=1;    
ELSE
	SET sex=2;
END IF;
  #设定注册时间和最后一次登陆时间相同
	INSERT INTO ms_memer(Uname,Password,email,Sex,Mobile,Regtime,Lastlogin,Image) VALUES (CONCAT(uname,mark),CONCAT(mark,upwd),CONCAT(mark,upwd,email),sex,CONCAT(1,FLOOR(RAND()*10000000000)),time,time,CONCAT(image,mark));
	#每次循环自增
	SET mark=mark+1;
END WHILE;
END
```

## 实现代码

```java
package Experiment.Demo2.Demo1;

import Advanced.JDBC.Util.DBUtils;

import java.sql.SQLException;

public class Demo1A {
    public static void main(String[] args) {
        DBUtils db=new DBUtils();
        try {
            //1.连接驱动
            db.getConnection();
            //2.根据数据库已有的存储过程执行sql
            db.executeUpdate("call addUsers(100)",null);
            System.out.println("已成功插入100条数据!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeAll();
        }
    }
}


//输出结果
已成功插入:100条数据

Process finished with exit code 0
```

## 插入100条数据后的ms_memer表

![](https://picture.hs-vae.com/image-20201224190737759.png)

插入100条数据成功，分两批插入的，可以查看代码详解