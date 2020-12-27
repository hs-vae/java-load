package com.hs_vae.Experiment.Demo2.Demo1;

import com.hs_vae.Experiment.Demo2.Demo2.db.DBUtil;

import java.sql.SQLException;

public class Demo1A {
    public static void main(String[] args) {
        DBUtil db = new DBUtil();
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
