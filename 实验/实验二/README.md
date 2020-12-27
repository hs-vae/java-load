<!-- toc -->

## 基本实训任务

根据下面数据库表逻辑结构,完成mobile_shop数据库的建表操作：

**会员信息表结构设计(ms_memer)**

| 键   | 字段描述         | 字段名    | 数据类型  | 字段长度 | 是否可空 | 备注    |
| ---- | ---------------- | --------- | --------- | -------- | -------- | ------- |
| P    | 会员标识         | member_id | int       | 11       | NOT NULL | 自动加1 |
|      | 会员名称         | Uname     | varchar   | 50       | NOT NULL |         |
|      | 密码             | Password  | varchar   | 50       | NOT NULL |         |
|      | 邮箱             | Email     | varchar   | 50       | NOT NULL |         |
|      | 性别             | Sex       | Smallint  | 6        | NULL     |         |
|      | 手机号码         | Mobile    | varchar   | 30       | NULL     |         |
|      | 注册时间         | Regtime   | timestamp |          | NOT NULL |         |
|      | 最后一次登录时间 | Lastlogin | timestamp |          | NOT NULL |         |
|      | 头像             | Image     | Varchar   | 500      | NULL     |         |

实现mobile_shop数据库的链接，实现如下SQL拟定的DAO编程

**要求:实现数据库连接时，参照书本和课件中的例子，数据库连接单独编写DBUtils类进行封装，mysql数据库的配置信息统一使用Properties类读取，读取配置操作单独编写Config类用静态调用方式读取配置信息。**

### a.编写存储过程实现会员信息数据的插入，功能测试时可以插入100条会员信息数据

### b.编写存储过程实现会员信息的删除，要求删除9月1日以前注册的会员信息(自行准备好测试数据)；

### c.编写存储过程查询出九月份有登陆过本系统会员信息要求查询出具体的会员名称和登陆时间；



## 贯穿实训任务

### 【任务2-1】创建项目所需的数据库表，并搭建数据访问基础环境。

q_dms.sql

mysql.properties

Config.java

DBUtil.java

### 【任务2-2】实现匹配的日志信息的保存和读取功能。

LogRecService.java

### 【任务2-3】实现匹配的物流信息的保存和读取功能。

TransportService.java

### 【任务2-4】测试匹配的日志、物流信息的数据库保存和查询功能。

DBDemo.java

