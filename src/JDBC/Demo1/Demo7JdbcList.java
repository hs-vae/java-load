package com.hs_vae.JDBC.Demo1;
/*
    定义一个方法，查询test表中的数据将其封装为对象，然后装载集合并且返回
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo7JdbcList {
    public static void main(String[] args) {
        List<Test> list=new Demo7JdbcList().findAll();
        //遍历查询hs数据库中的test表中所有数据
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //查看有几条数据
        System.out.println(list.size());
    }

    public List<Test> findAll(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        //创建一个以Test类test对象，并且赋为空值，让test能够复用,写try外面
        Test test=null;
        List<Test> list=null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.加载驱动
            conn= DriverManager.getConnection("jdbc:mysql:///hs","root","hs101544");
            //3.定义sql语句
            String sql="select * from test";
            //4.获取执行sql的对象
            stmt=conn.createStatement();
            //5.定义结果集
            rs=stmt.executeQuery(sql);
            //6.查询
            list=new ArrayList<Test>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                test =new Test();
                test.setId(id);
                test.setName(name);
                test.setPrice(price);
                //将test对象中的id,name,price装载到list集合里面
                list.add(test);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
