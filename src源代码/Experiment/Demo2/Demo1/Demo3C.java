package com.hs_vae.Experiment.Demo2.Demo1;

import com.hs_vae.Experiment.Demo2.Demo2.db.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    要求:编写存储过程查询出九月份有登陆过本系统会员信息要求查询出具体的会员名称和登陆时间
 */
public class Demo3C {
    public static void main(String[] args) {
        DBUtil db=new DBUtil();
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
