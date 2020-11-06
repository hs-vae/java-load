<!-- toc -->

# 任务：编写存储过程实现会员信息数据的插入，功能测试时可以插入100条会员信息数据

## 在DataGrip中建立一个ms_memer表

![](https://picture.hs-vae.com/建立表.png)

## 实现代码

```java
package Experiment.Demo2;

import Advanced.JDBC.Util.DBUtils;

import java.sql.SQLException;

public class Demo1A {
    public static void main(String[] args) {
        DBUtils db=new DBUtils();
        //设置9月份的注册时间s1
        String s1="2020-09-12 16:29:58";
        //设置9月1日以前的注册时间s2
        String s2="2020-08-06 15:32:31";
        int sum=0;
        try {
            //1.连接驱动
            db.getConnection();
            //2.定义sql语句
            String sql="insert into ms_memer(member_id,Uname,Password,Email,Sex,Mobile,Regtime,Lastlogin,Image) values (?,?,?,?,?,?,?,?,?)";
            //3.使用循环对表插入数据,调用工具类中的executeUpdate方法
            for (int i = 0; i < 100; i++) {
                if(i<49){
                    //插入前50条9月份最后一次登录的数据
                    db.executeUpdate(sql,new String[]{null,"hs","123456","hs@qq.com","1","18872748895",s1,s1,"hs-vae"});
                }else {
                    //插入后50条9月1日之前最后一次登录的数据
                    db.executeUpdate(sql,new String[]{null,"vae","123456","hs@qq.com","0","18872748895",s2,s2,"hs-vae"});
                }
                ++sum;
            }
            System.out.println("已成功插入:"+sum+"条数据");
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

![](https://picture.hs-vae.com/插入100条数据.png)

插入100条数据成功，分两批插入的，可以查看代码详解