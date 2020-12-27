package com.hs_vae.Experiment.Demo2.Demo1;

import com.hs_vae.Experiment.Demo2.Demo2.db.DBUtil;

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
