package com.hs_vae.JDBC.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Demo1Druid {
    public static void main(String[] args) throws Exception {
        //1.导入jar包 druid-1.0.9.jar
        //2.定义配置文件 druid.properties
        //3.加载配置文件
        Properties pro=new Properties();
        InputStream is = Demo1Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5.获取连接
        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
