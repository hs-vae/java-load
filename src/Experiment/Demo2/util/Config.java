package com.hs_vae.Experiment.Demo2.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//配置类Config
public class Config {
    private static Properties p=null;
    static {
        try {
            //加载配置文件
            p=new Properties();
            p.load(new FileInputStream("/home/hs/IdeaProjects/vae/src/mysql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 获取键对应的值
    public static String getValue(String key){
        return p.get(key).toString();
    }
}
