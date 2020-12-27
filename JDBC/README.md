<!-- toc -->

JDBC概念 : Java DateBase Connectivity  Java  数据库连接，Java语言操作数据库

JDBC本质: 其实是官方定义的一套操作所有关系类型数据库的规则，即接口。各个数据厂商去实现这套接口，提供数据库驱动jar包，我们可以使用这套接口(JDBC)编程，真正执行的代码是驱动jar包中的实现类

### 步骤:

#### 1.导入jar包

下载好的jar包在工程里面建立一个libs文件夹，右键点击Add  as  Library....(IDEA为例)

![](https://picture.hs-vae.com/图片/java图片/JDBC导jar包.png)

#### 2.注册驱动

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

#### 3.获取数据库连接对象 Connection

```java
Connection   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hs","root","123456");
```

#### 4.定义sql

```java
String sql="update test set name='yg' where id=1";
```

#### 5.获取执行sql语句的对象 Statement

```java
Statement stmt=conn.createStatement();
```

#### 6.执行sql，接受返回结果

```java
int count=stmt.executeUpdate(sql);
```

#### 7.处理结果

```java
System.out.println(count);
```

#### 8.释放资源

```java
stmt.close();
conn.close();
```

### 最终结果截图

workbench  id=5的那一行本来是jay，执行成功后idea输出1，workbench刷新后jay变成了vae

![](https://picture.hs-vae.com/图片/java图片/JDBCDemo1.png)