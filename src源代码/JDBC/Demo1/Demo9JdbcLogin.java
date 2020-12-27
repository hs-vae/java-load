package com.hs_vae.JDBC.Demo1;

import com.hs_vae.JDBC.Util.DBUtils;

import java.sql.*;
import java.util.Scanner;

/*
    练习:
       1. 通过键盘录入用户名和密码
       2. 判断用户是否成功
 */
public class Demo9JdbcLogin {
    public static void main(String[] args) {
        //1.键盘录入用户名和密码
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        //2.创建一个主类login方法对象
        boolean flag=new Demo9JdbcLogin().login(username,password);
        //3.判断用户是否成功
        if (flag){
            System.out.println("登录成功!");
        }else {
            System.out.println("用户名和密码错误!");
        }
    }
    public boolean login(String username,String password){
        //先判断用户名和密码是否为空
        if(username ==null && password ==null){
            return false;
        }
        DBUtils db=new DBUtils();
        try {
            //1.注册且获取连接驱动
            db.getConnection();
            //2.定义sql查询用户名和密码语句
            String sql = "select * from user where username= ? and password= ?";
            return db.executeQuery(sql,new String[]{username,password}).next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeAll();
        }
        return false;
    }
}
