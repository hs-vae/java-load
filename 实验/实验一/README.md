[TOC]

## 一、基本任务:(实现代码包括了三个需要编写的方法)

1) 完成如下图所示log.txt日志文件的分析，编写方法分析访问量排名前10的IP地址打印输出。 

2) 编写方法读取日志文件分析出有哪几种不同的错误异常。

3)编写方法完成日志文件的字段对象封装，完成对象的序列化。

### 1.先创建一个Log类

```java
package Demo5Experiment.Demo1;
import java.io.Serializable;
//对log.txt日志文件的字段进行对象封装
public class Log implements Serializable {            //序列化和反序列化的时候,会抛出NotSerializableException没有序列化异常
    private static  final  long serialVersiouUID=1L;  //可以解决序列化冲突异常
    private String name;
    private String time;
    private String Ip;
    private String status;
    private String information;
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return  "Log{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", Ip='" + Ip + '\'' +
                ", status='" + status + '\'' +
                ", information='" + information + '\'' +
                '}';
    }

    public Log(String name, String time, String Ip, String status, String information) {
        this.name = name;
        this.time=time;
        this.Ip=Ip;
        this.status=status;
        this.information=information;
    }
    public Log(String s) {
    }

    public String getIp() {
        return Ip;
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

### 2.实现代码

```java
package Experiment.Demo1;
/*
      实验一基本任务：
            1.打印排名前十IP地址
            2.输出不同的"ERROR"异常信息
            3.对象序列化
 */
import com.microsoft.schemas.vml.impl.CTRectImpl;

import java.io.*;
import java.util.*;
public class Demo1Experiment {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //打印排名前十IP地址
        printIp(new FileReader("vae/log.txt"));
        //输出不同的异常信息
        printError(new FileReader("vae/log.txt"));
        //Log对象的序列化
        objectLog(new FileReader("vae/log.txt"),new FileOutputStream("vae/objectlog.txt"),new FileInputStream("vae/objectlog.txt"));
    }
    private static void printIp(FileReader file) throws IOException {
        BufferedReader br = new BufferedReader(file);
        String line;
        Map<String,Integer> map = new HashMap<>();
        while ((line= br.readLine())!=null){
            String[] split = line.split(",", 5);
            String key = split[2].trim().replace(" ", "");
            //判断这个集合是否包含这个ip
            if (map.containsKey(key)){
                //若包含,那么value加1
                Integer value = map.get(key);
                value++;
                map.put(key,value);
            }else {
                //若不包含,这时候初始值为1
                map.put(key,1);
            }
        }
        //HashMap集合是无序的要想给出现的次数排序那么就应该放到List集合里
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue(); //降序
            }
        });
        System.out.println("访问量排名前十的IP地址:");
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
        br.close();
    }

    private static void printError(FileReader file) throws IOException {
        BufferedReader br = new BufferedReader(file);
        ArrayList<String> list=new ArrayList<>(); //存储"ERROR"和"LOG"
        Set<String> set=new HashSet<>();    //Hashset类比较特殊,可以去重,所以可以采用add方法解决异常信息重复问题
        String line;
        int i=0;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",",5);
            list.add(arr[3]);
                if(list.get(i).trim().equals("ERROR")){   //注意这里得利用String类的trim除去空格,而且需要equals方法判断是否相等(因为存储的还是地址值),而不是==
                     set.add(arr[4]);
                }
            ++i;
        }
        System.out.println("错误异常信息：");
        for(String s:set){
            System.out.println(s);    //HashSet由于没有索引值,只能用加强的for循环和迭代器来遍历
        }
        br.close();
    }
    private static void objectLog(FileReader file1,FileOutputStream file2,FileInputStream file3) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos =new ObjectOutputStream(file2);
        BufferedReader br =new BufferedReader(file1);
        ObjectInputStream ois = new ObjectInputStream(file3);
        ArrayList<Log> list =new ArrayList<>();   //用来存储Log对象
        String  line;
        //序列化,先将该文件以','隔开切割成5份,然后添加到ArrayList类型的list集合中去,通过遍历对list集合进行序列化
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",",5);
            list.add(new Log(arr[0],arr[1],arr[2],arr[3],arr[4]));   //添加name
        }
        for (int i = 0; i < list.size(); i++) {
            oos.writeObject(list);
        }
        //反序列化,打印输出出来
        Object o=ois.readObject();
        ArrayList<Log> a=(ArrayList<Log>)o;  //Object类型的集合转换为ArrayList类型
        System.out.println("序列化后:");
        for (Log p:a){
            System.out.println(p);
        }
        //释放资源
        oos.close();
        br.close();
        ois.close();
    }
}
```

## 二、贯穿任务(物流管理系统)

1) 【任务1-1】 升级实体类为可序列化的类，以便在文件中保存或网络中传递。

DataBase.java

LogRec.java

MatchedLogRec.java

Transport.java

MatchedTransport.java

2) 【任务1-2】 实现匹配的日志信息的保存和读取功能。

LogRecService.java

3) 【任务1-3】 实现匹配的物流信息的保存和读取功能。

TransportService.java

4) 【任务1-4】测试匹配的日志、物流信息的保存和读取功能。

FileDemo.java

### 任务1-1升级实体类为可序列化的类，以便在文件中保存或网络中传递。

#### DataBase.java

```java
package com.qst.dms.entity;
import java.io.Serializable;
import java.util.Date;

//数据基础类

public class DataBase  implements Serializable{
	// ID标识
	private int id;
	// 时间
	private Date time;
	// 地点
	private String address;
	// 状态
	private int type;
	// 状态常量
	public static final int GATHER=1;//"采集"
	public static final int MATHCH=2;//"匹配";
	public static final int RECORD=3;//"记录";
	public static final int SEND=4;//"发送";
	public static final int RECIVE=5;//"接收";
	public static final int WRITE=6;//"归档";
	public static final int SAVE=7;//"保存";

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}


	public Date getTime() {
		return time;
	}

	
	public void setTime(Date time) {
		this.time = time;
	}


	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public DataBase() {
	}

	public DataBase(int id, Date time, String address, int type) {
		this.id = id;
		this.time = time;
		this.address = address;
		this.type = type;
	}

	public String toString() {
		return id + "," + time + "," + address + "," + type;
	}
}
```

#### LogRec.java

```java
package com.qst.dms.entity;

import java.io.Serializable;
import java.util.Date;

//用户登录日志记录
public class LogRec extends DataBase implements Serializable{
	/**
	 *  登录用户名
	 */
	private String user;
	/**
	 * 登录用户主机IP地址
	 */
	private String ip;
	/**
	 * 登录状态：登录、登出
	 */
	private int logType;
	/**
	 * 登录常量LOG_IN、登出常量常量LOG_OUT
	 */
    public static final int LOG_IN=1;
    public static final int LOG_OUT=0;
    
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getLogType() {
		return logType;
	}

	
	public void setLogType(int logType) {
		this.logType = logType;
	}

	public LogRec() {
	}

	public LogRec(int id, Date time, String address, int type,String user,String ip,int logType) {
		super(id,time,address,type);
		this.user=user;
		this.ip=ip;
		this.logType=logType;
	}
	
	public String toString() {
		return this.getId() + "," +this.getTime() + "," +this.getAddress() + "," + this.getType() + ","+user+","+ip+","+logType;
	}
}

```

#### MatchedLogRec.java

```java
package com.qst.dms.entity;

import java.io.Serializable;
import java.util.Date;

//匹配日志记录，"登录登出对" 类型

public class MatchedLogRec implements  Serializable{

	private LogRec login;
	private LogRec logout;

	// user用户登录名
	public String getUser() {
		return login.getUser();
	}

	// 登入时刻
	public Date getLogInTime() {
		return login.getTime();
	}

	// 登出时刻
	public Date getLogoutTime() {
		return logout.getTime();
	}

	// 登入记录
	public LogRec getLogin() {
		return login;
	}

	// 登出记录
	public LogRec getLogout() {
		return logout;
	}

	public MatchedLogRec() {
	}

	public MatchedLogRec(LogRec login, LogRec logout) {
		if (login.getLogType() != LogRec.LOG_IN) {
			throw new RuntimeException("不是登录记录!");
		}
		if (logout.getLogType() != LogRec.LOG_OUT) {
			throw new RuntimeException("不是登出记录");
		}
		if (!login.getUser().equals(logout.getUser())) {
			throw new RuntimeException("登录登出必须是同一个用户!");
		}
		if (!login.getIp().equals(logout.getIp())) {
			throw new RuntimeException("登录登出必须是同一个IP地址!");
		}
		this.login = login;
		this.logout = logout;
	}
	public String toString() {
		return login.toString() + " | " + logout.toString();
	}
}
```

#### Transport.java

```java
package com.qst.dms.entity;

import java.io.Serializable;
import java.util.Date;

//货运物流信息
public class Transport extends DataBase implements  Serializable{
	/**
	 * 经手人
	 */
	private String handler;
	/**
	 * 收货人
	 */
	private String reciver;
	/**
	 * 物流状态
	 */
	private int transportType;
	/**
	 * 物流状态常量:发货中, 送货中, 已签收
	 */
	public static final int SENDDING = 1;// 发货中
	public static final int TRANSPORTING = 2;// 送货中
	public static final int RECIEVED = 3;// 已签收

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public int getTransportType() {
		return transportType;
	}

	public void setTransportType(int transportType) {
		this.transportType = transportType;
	}

	public Transport() {

	}

	public Transport(int id, Date time, String address, int type,
			String handler, String reciver, int transportType) {
		super(id, time, address, type);
		this.handler = handler;
		this.reciver = reciver;
		this.transportType = transportType;
	}

	public String toString() {
		return this.getId() + "," + this.getTime() + "," + this.getAddress()
				+ "," + this.getType() + "," + handler + "," + transportType;
	}
}

```

#### MatchedTransport.java

```java
package com.qst.dms.entity;

import java.io.Serializable;

public class MatchedTransport implements Serializable{
	private Transport send;
	private Transport trans;
	private Transport receive;

	public Transport getSend() {
		return send;
	}

	public void setSend(Transport send) {
		this.send = send;
	}

	public Transport getTrans() {
		return trans;
	}

	public void setTrans(Transport trans) {
		this.trans = trans;
	}

	public Transport getReceive() {
		return receive;
	}

	public void setReceive(Transport receive) {
		this.receive = receive;
	}

	public MatchedTransport() {

	}

	public MatchedTransport(Transport send, Transport trans, Transport receive) {
		if (send.getTransportType() != Transport.SENDDING) {
			throw new RuntimeException("不是发货记录!");
		}
		if (trans.getTransportType() != Transport.TRANSPORTING) {
			throw new RuntimeException("不是送货记录!");
		}
		if (receive.getTransportType() != Transport.RECIEVED) {
			throw new RuntimeException("不是签收记录!");
		}
		this.send = send;
		this.trans = trans;
		this.receive = receive;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return send.toString() + "|" + trans.toString() + "|" + receive;
	}
}
```

### 任务1-2 实现匹配的日志信息的保存和读取功能。

#### LogRecService.java

```java
package com.qst.dms.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.qst.dms.entity.DataBase;
import com.qst.dms.entity.LogRec;
import com.qst.dms.entity.MatchedLogRec;

//日志业务类
public class LogRecService {

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

	// 匹配日志信息保存，参数是集合
	public void saveMatchLog(ArrayList<MatchedLogRec> matchLogs) throws IOException, ClassNotFoundException {
		  ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("matchlog.txt"));
		  for(MatchedLogRec e:matchLogs){
		  	if (e!=null){
				oos.writeObject(e);
			}
		  }
		  oos.writeObject(null);  //文件末尾加一个null,标记着结束
		oos.flush();
		oos.close();
	}

	// 读匹配日志信息保存，参数是集合
	public ArrayList<MatchedLogRec> readMatchLog() throws IOException, ClassNotFoundException {
		ArrayList<MatchedLogRec> matchLogs=new ArrayList<>();
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("matchlog.txt"));
		MatchedLogRec matchLog;
		while ((matchLog=(MatchedLogRec)ois.readObject())!=null){
			matchLogs.add(matchLog);
		}
		ois.close();
		return matchLogs;
	}
}
```

### 任务1-3 实现匹配的物流信息的保存和读取功能。

#### TransportService.java

```java
package com.qst.dms.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.qst.dms.entity.DataBase;
import com.qst.dms.entity.MatchedLogRec;
import com.qst.dms.entity.MatchedTransport;
import com.qst.dms.entity.Transport;

public class TransportService {
	// 物流数据采集
	public Transport inputTransport() {
		Transport trans = null;
		// 建立一个从键盘接收数据的扫描器
		Scanner scanner = new Scanner(System.in);
		try{
			// 提示用户输入ID标识
			System.out.println("请输入ID标识：");
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
			System.out.println("请输入货物经手人：");
			// 接收键盘输入的字符串信息
			String handler = scanner.next();
			// 提示用户输入主机IP
			System.out.println("请输入 收货人:");
			// 接收键盘输入的字符串信息
			String reciver = scanner.next();
			// 提示用于输入物流状态
			System.out.println("请输入物流状态：1发货中，2送货中，3已签收");
			// 接收物流状态
			int transportType = scanner.nextInt();
			// 创建物流信息对象
			trans = new Transport(id, nowDate, address, type, handler, reciver,
					transportType);
		} catch (Exception e) {
			System.out.println("采集的日志信息不合法");
		}
		// 返回物流对象
		return trans;
	}

	// 物流信息输出
	public void showTransport(Transport... transports) {
		for (Transport e : transports) {
			if (e != null) {
				System.out.println(e.toString());
			}
		}
	}

	// 匹配的物流信息输出，可变参数
	public void showMatchTransport(MatchedTransport... matchTrans) {
		for (MatchedTransport e : matchTrans) {
			if (e != null) {
				System.out.println(e.toString());
			}
		}
	}
	// 匹配的物流信息输出，参数是集合
	public void showMatchTransport(ArrayList<MatchedTransport> matchTrans) {
		for (MatchedTransport e : matchTrans) {
			if (e != null) {
				System.out.println(e.toString());
			}
		}
	}
	
	// 匹配物流信息保存，参数是集合
	public void saveMatchedTransport(ArrayList<MatchedTransport> matchTrans) throws IOException {
    ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("matchtrans.txt"));
		for (MatchedTransport e:matchTrans) {
			if(e!=null){
				oos.writeObject(e);
			}
		}
		oos.writeObject(null);  //文件末尾加一个null,标记着结束
		oos.flush();
		oos.close();
	}

	// 读匹配物流信息保存，参数是集合
	public ArrayList<MatchedTransport> readMatchedTransport() throws IOException, ClassNotFoundException {
		ArrayList<MatchedTransport> matchTrans=new ArrayList<>();
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("matchtrans.txt"));
		MatchedTransport matchTran;
		while ((matchTran=(MatchedTransport) ois.readObject())!=null){
			   matchTrans.add(matchTran);
		}
		ois.close();
		return matchTrans;
	}
	
}
```

### 任务1-4 测试匹配的日志、物流信息的保存和读取功能。

#### FileDemo.java

```java
package com.qst.dms.dos;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import com.qst.dms.entity.DataBase;
import com.qst.dms.entity.LogRec;
import com.qst.dms.entity.MatchedLogRec;
import com.qst.dms.entity.MatchedTransport;
import com.qst.dms.entity.Transport;
import com.qst.dms.service.LogRecService;
import com.qst.dms.service.TransportService;
public class FileDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 创建一个日志业务类
		LogRecService logService = new LogRecService();
		ArrayList<MatchedLogRec> matchLogs = new ArrayList<>();
		matchLogs.add(new MatchedLogRec(
				new LogRec(1001, new Date(), "青島",DataBase.GATHER, "zhangsan", "192.168.1.1", 1),
				new LogRec(1002, new Date(), "青島", DataBase.GATHER, "zhangsan",	"192.168.1.1", 0)));
		matchLogs.add(new MatchedLogRec(
				new LogRec(1003, new Date(), "北京",DataBase.GATHER, "lisi", "192.168.1.6", 1), 
				new LogRec(1004, new Date(), "北京", DataBase.GATHER, "lisi", "192.168.1.6", 0)));
		matchLogs.add(new MatchedLogRec(
				new LogRec(1005, new Date(), "济南",DataBase.GATHER, "wangwu", "192.168.1.89", 1),
				new LogRec(1006, new Date(), "济南", DataBase.GATHER,	"wangwu", "192.168.1.89", 0)));

		//保存匹配的日志信息到文件中
		logService.saveMatchLog(matchLogs);		
		//从文件中读取匹配的日志信息
		ArrayList<MatchedLogRec> logList=logService.readMatchLog();
        System.out.println("-------------------------日志信息-------------------------");
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

		//保存匹配的物流信息到文件中
		tranService.saveMatchedTransport(matchTrans);		
		//从文件中读取匹配的物流信息
        ArrayList<MatchedTransport> tranList=tranService.readMatchedTransport();
        System.out.println("--------------------------物流信息------------------------");
        tranService.showMatchTransport(tranList);
	}
}
```

