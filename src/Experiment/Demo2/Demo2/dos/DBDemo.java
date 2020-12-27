package com.hs_vae.Experiment.Demo2.Demo2.dos;

import com.hs_vae.Experiment.Demo2.Demo2.entity.*;
import com.hs_vae.Experiment.Demo2.Demo2.service.LogRecService;
import com.hs_vae.Experiment.Demo2.Demo2.service.TransportService;

import java.util.ArrayList;
import java.util.Date;

public class DBDemo {
    public static void main(String[] args) {
        // 创建一个日志业务类
        LogRecService logService = new LogRecService();
        ArrayList<MatchedLogRec> matchLogs = new ArrayList<>();
        matchLogs.add(new MatchedLogRec(
                new LogRec(1001, new Date(), "青島", DataBase.GATHER, "zhangsan", "192.168.1.1", 1),
                new LogRec(1002, new Date(), "青島", DataBase.GATHER, "zhangsan",	"192.168.1.1", 0)));
        matchLogs.add(new MatchedLogRec(
                new LogRec(1003, new Date(), "北京",DataBase.GATHER, "lisi", "192.168.1.6", 1),
                new LogRec(1004, new Date(), "北京", DataBase.GATHER, "lisi", "192.168.1.6", 0)));
        matchLogs.add(new MatchedLogRec(
                new LogRec(1005, new Date(), "济南",DataBase.GATHER, "wangwu", "192.168.1.89", 1),
                new LogRec(1006, new Date(), "济南", DataBase.GATHER,	"wangwu", "192.168.1.89", 0)));
        //保存匹配的日志信息到数据库中
        logService.saveMatchLogToDB(matchLogs);
        //从数据库中读取匹配的日志信息
        ArrayList<MatchedLogRec> logList=logService.readMatchedLogFromDB();
        logService.showMatchLog(logList);

        // 创建一个物流业务类
        TransportService tranService = new TransportService();
        ArrayList<MatchedTransport> matchTrans = new ArrayList<>();
        matchTrans.add(new MatchedTransport(
                new Transport(2001, new Date(), "青島",DataBase.GATHER,"zhangsan","zhaokel",1),
                new Transport(2002, new Date(), "北京",DataBase.GATHER,"lisi","zhaokel",2),
                new Transport(2003, new Date(), "北京",DataBase.GATHER,"wangwu","zhaokel",3)));
        matchTrans.add(new MatchedTransport(
                new Transport(2004, new Date(), "青島",DataBase.GATHER,"maliu","zhaokel",1),
                new Transport(2005, new Date(), "北京",DataBase.GATHER,"sunqi","zhaokel",2),
                new Transport(2006, new Date(), "北京",DataBase.GATHER,"fengba","zhaokel",3)));
        //保存匹配的物流信息到数据库中
        tranService.saveMatchTransportToDB(matchTrans);
        //从数据库中读取匹配的物流信息
        ArrayList<MatchedTransport> transportList=tranService.readMatchedTransportFromDB();
        tranService.showMatchTransport(transportList);
    }
}
