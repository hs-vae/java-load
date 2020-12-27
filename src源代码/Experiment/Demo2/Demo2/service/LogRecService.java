package com.hs_vae.Experiment.Demo2.Demo2.service;
import com.hs_vae.Experiment.Demo2.Demo2.db.DBUtil;
import com.hs_vae.Experiment.Demo2.Demo2.entity.DataBase;
import com.hs_vae.Experiment.Demo2.Demo2.entity.LogRec;
import com.hs_vae.Experiment.Demo2.Demo2.entity.MatchedLogRec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//日志业务类
public class LogRecService {
    //...
    // 日志数据采集
    public LogRec inputLog() {
        LogRec log = null;
        // 建立一个从键盘接收数据的扫描器
        Scanner scanner = new Scanner(System.in);
        try {
            // 提示用户输入ID标识
            System.out.println("请输入ID标识：   ");
            // 接收键盘输入的整数
            int id = scanner.nextInt();
            // 获取当前系统时间
            Date nowDate = new Date();
            // 提示用户输入地址
            System.out.println("请输入地址：");
            // 接收键盘输入的字符串信息
            String address = scanner.next();
            // 数据状态是“采集”
            int type = DataBase.GATHER;

            // 提示用户输入登录用户名
            System.out.println("请输入 登录用户名：");
            // 接收键盘输入的字符串信息
            String user = scanner.next();
            // 提示用户输入主机IP
            System.out.println("请输入 主机IP:");
            // 接收键盘输入的字符串信息
            String ip = scanner.next();
            // 提示用户输入登录状态、登出状态
            System.out.println("请输入登录状态:1是登录，0是登出");
            int logType = scanner.nextInt();
            // 创建日志对象
            log = new LogRec(id, nowDate, address, type, user, ip, logType);
        } catch (Exception e) {
            System.out.println("采集的日志信息不合法");
        }
        // 返回日志对象
        return log;
    }

    // 日志信息输出
    public void showLog(LogRec... logRecs) {
        for (LogRec e : logRecs) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }

    // 匹配日志信息输出，可变参数
    public void showMatchLog(MatchedLogRec... matchLogs) {
        for (MatchedLogRec e : matchLogs) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }

    // 匹配日志信息输出,参数是集合
    public void showMatchLog(ArrayList<MatchedLogRec> matchLogs) {
        for (MatchedLogRec e : matchLogs) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }

    //匹配日志信息保存到数据库,参数是集合
    public void saveMatchLogToDB(ArrayList<MatchedLogRec> matchLogs){
        DBUtil db=new DBUtil();

        try {
            //获取数据库连接
            db.getConnection();
            for (MatchedLogRec matchedLogRec:matchLogs){
                //获取匹配的登录日志
                LogRec login=matchedLogRec.getLogin();
                //获取匹配的登出日志
                LogRec logout=matchedLogRec.getLogout();
                //保存匹配记录中的登录日志
                String sql="insert into GATHER_LOGREC(id,time,address,type,username,ip,logtype) values(?,?,?,?,?,?,?)";
                Object[] param=new Object[]{ login.getId(),
                        new Timestamp(login.getTime().getTime()),
                        login.getAddress(),login.getType(),login.getUser(),
                        login.getIp(),login.getLogType()
                };
                db.executeUpdate(sql,param);
                //保存匹配记录中的登录日志
                param =new Object[]{logout.getId(),
                        new Timestamp(logout.getTime().getTime()),
                        logout.getAddress(),logout.getType(),
                        logout.getUser(),logout.getIp(),logout.getLogType()
                };
                db.executeUpdate(sql,param);
                //保存匹配日志的ID
                sql="insert into MATCHED_LOGREC(loginid,logoutid) values(?,?)";
                param=new Object[]{login.getId(),logout.getId()};
                db.executeUpdate(sql,param);
            }
            //关闭数据库连接,释放资源
            db.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    //从数据库读匹配日志信息,返回匹配日志信息集合
    public ArrayList<MatchedLogRec> readMatchedLogFromDB(){
       ArrayList<MatchedLogRec> matchedLogRecs=new ArrayList<MatchedLogRec>();
       DBUtil db=new DBUtil();
        try {
            //获取数据库连接
            db.getConnection();
            //查询匹配的日志
       String sql="select i.id,i.time,i.address,i.type,i.username,i.ip,i.logtype," +
               "o.id,o.time,o.address,o.type,o.username,o.ip,o.logtype from MATCHED_LOGREC m, GATHER_LOGREC i," +
               "GATHER_LOGREC o where m.loginid=i.id and m.logoutid=o.id";
            ResultSet rs=db.executeQuery(sql,null);
            while(rs.next()){
                //获取登录记录
                LogRec login=new LogRec(rs.getInt(1),rs.getDate(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getString(6),rs.getInt(7));
                //获取登出记录
                LogRec logout=new LogRec(rs.getInt(8),rs.getDate(9),
                        rs.getString(10),rs.getInt(11),rs.getString(12),
                        rs.getString(13),rs.getInt(14));
                //添加匹配登录信息到匹配集合
                MatchedLogRec matchedLog=new MatchedLogRec(login,logout);
                matchedLogRecs.add(matchedLog);
            }
            //关闭数据库连接,释放资源
            db.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matchedLogRecs;
    }
}
