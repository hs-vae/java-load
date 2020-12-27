# 网络通信协议

## UDP

用户数据报协议，UDP是**无连接通信协议**，即在数据传输时，数据的发送端和接收端不建立逻辑连接。简单来说，当一台计算机向另外一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会向发送端反馈是否收到数据

由于使用UDP协议消耗资源小，通信效率高，所以通常都会用于音频、视频和普通数据的传输例如视频会议都使用UDP协议，因为这种情况即使偶尔丢失一两个数据包，也不会对接收结果产生太大影响

但是在使用UDP协议传送数据时，由于UDP的面向无连接性，不能保证数据的完整性，因此在传输重要数据时不建议使用UDP协议

特点：数据被限制在64kb以内，超过这个范围就不能发送了

数据报：网络传输的基本单位

## TCP

传输控制协议。TCP协议是**面向连接**的通信协议，即传输数据之前，在发送端和接收端建立逻辑连接，然后再传输数据，然后再传输数据，它提供了两台计算机之间可靠无差错的数据传输

在TCP连接中必须要明确客户端与服务器端，由客户端向服务端发出连接请求，每次传输的创建都需要经过"三次握手"。

### 三次握手

> 第一次握手

客户端向服务器端发出连接请求，等待服务器确认

> 第二次握手

服务器端向客户端回送一个响应，通知客户端收到了连接请求

> 第三次握手

客户端再次向服务器端发送确认信息，确认连接

完成三次握手，连接建立后，客户端和服务器就可以开始进行数据传输了。由于这种面向连接的特性，TCP协议可以保证传输数据的安全，所以应用十分广泛，例如下载文件、浏览网页等

# TCP通信

## 客户端

TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据

表示客户端的类：

```java
java.net.Socket：此类实现客户端套接字，套接字是两台机器间通信的端点
    套接字：包含了Ip地址和端口号的网络单位 
```

构造方法：

```java
Socket(String host,int port) 创建一个流套接字并将其连接到指定主机上的指定端口号
    参数：
        String host：服务器主机的名称/服务器的IP地址
        int port：服务器的端口号
```

成员方法：

```java
OutputStream getOutputStream()  返回此套接字的输出流
InputStream  getInputStream()  返回此套接字的输入流
void  close()  关闭此套接字
```

实现步骤：

1. 创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
2. 使用Socket对象中的方法getOutputStream() 获取网络字节输出流OutputStream对象
3. 使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
4. 使用Socket对象中的方法getInputStream()  获取网络字节输入流InputStream对象
5. 使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
6. 释放资源(Socket)

注意：

1. 客户端和服务器端进行交互时，必须使用Socket中提供的网络流，不能使用自己创建的流对象
2. 当我们创建客户端对象Socket的时候，就会去请求服务器和服务器经过3次握手建立连接通路，如果服务器没有启动就会抛出异常

测试

```java
package Advanced.Net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
        Socket socket=new Socket("127.0.0.1",8000);
        //2.使用Socket对象中的方法getOutputStream() 获取网络字节输出流OutputStream对象
        OutputStream os=socket.getOutputStream();
        //3.使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
        os.write("发送请求给服务器!".getBytes());
        //4.使用Socket对象中的方法getInputStream()  获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6.释放资源(Socket)
        socket.close();
    }
}

//输出结果
客户端做出回应
```

## 服务器端  

TCP通信的服务器端：接收客户端的请求，读取客户端发送的数据，给客户端回写数据、

表示服务器的类： java.net.ServerSocket：此类实现服务器套接字

构造方法：

ServerSocket(int  port) 创建绑定到特定端口的服务器套接字

服务器端首先要明确是哪个客户端请求的服务器，所以可以用accept方法获取到请求的客户端对象Socket

成员方法：

Socket   accept ()  侦听并接收到此套接字的连接。

服务器的实现步骤：

1. 创建服务器ServerSocket对象和系统要指定的端口号
2. 使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
3. 使用Socket对象中的方法getInputStream() 获取网络字节输入流InputStream对象
4. 使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
5. 使用Socket对象中的方法getOutputStream()  获取网络字节输出流OutputStream对象
6. 使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
7. 释放资源(Socket，ServerSocket)

测试

```java
package Advanced.Net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket server=new ServerSocket(8000);
        //2.使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
        Socket socket=server.accept();
        //3.使用Socket对象中的方法getInputStream() 获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //4.使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //5.使用Socket对象中的方法getOutputStream() 获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //6.使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
        os.write("收到客户端的请求!".getBytes());
        //7.释放资源
        socket.close();
        server.close();
    }
}

//输出结果
发送请求给服务器!
```

# 文件上传案例

原理：客户端读取本地的文件，把文件上传到服务器，服务器在把上传的文件保存到服务器的硬盘上

1. 客户端使用本地的字节输入流，读取要上传的文件
2. 客户端使用网络字节输出流，把读取到的文件上传到服务器
3. 服务器使用网络字节输入流，读取客户端上传的文件
4. 服务器使用本地字节输出流，吧读取到的文件，保存到服务器的硬盘上
5. 服务器使用网络字节输出流，给客户端回写一个"上传成功"
6. 客户端使用网络字节输入流，读取服务器回写的数据
7. 释放资源

![](https://picture.hs-vae.com/TCP文件上传案例2.png)

## 客户端

文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据

数据源：/home/hs/图片/dog.png

目的地：服务器Centos7   

实现步骤：

1. 创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
2. 创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
3. 使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象
4. 使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
5. 使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
6. 使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
7. 使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据
8. 释放资源

测试

```java
package Advanced.Net.FileUpload;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis=new FileInputStream("/home/hs/图片/dog.jpg");
        //2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket=new Socket("hs-vae.com",8080);
        //3.使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //4.使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            //5.使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
            os.write(bytes,0,len);
        }
        /*
             解决文件阻塞问题：上传完文件，给服务器写一个结束标记
             void shutdownOutput() 禁用此套接字的输出流
             对于TCP 套接字，任何以前写入的数据都将被发送，并且后跟TCP的正常连接终止序列
         */
        socket.shutdownOutput();
        //6.使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //7.使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据
        while ((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        //8.释放资源
        fis.close();
        socket.close();
    }
}
```

## 服务器端

文件上传案例的服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写"上传成功"

数据源：客户端上传的文件

目的地：服务器的硬盘： /hs

实现步骤：

1. 创建一个服务器ServerSocket对象
2. 使用ServerSocket对象中的方法accept，获取到请求的客户端Socket对象
3. 使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
4. 判断/home/hs/桌面 文件夹是否存在，不存在则创建
5. 创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
6. 使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
7. 使用本地字节输出流FIleOutputStream对象中的方法write，把读取到的文件保存到服务器的硬盘上
8. 使用Socket对象中的方法getOutputStream，获取到网络字节输出流OutputStream对象
9. 使用网络字节输出流OutputStream对象中的方法write，给客户端回写"上传成功"
10. 释放资源

测试

```java
package Advanced.Net.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务器ServerSocket对象
        ServerSocket server=new ServerSocket(8080);
        //2.使用ServerSocket对象中的方法accept，获取到请求的客户端Socket对象
        /*
           让服务器一直处于监听状态(死循环accept方法)
           有一个客户端上传文件，就保存一个文件
         */
        while (true){
            Socket socket = server.accept();
            /*
                使用多线程技术，提高程序效率
                有一个客户端上传文件，就开启一个线程，完成文件的上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3.使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
                        //4.判断/home/hs/桌面 文件夹是否存在，不存在则创建
                        File file=new File("/hs");
                        if (!file.exists()){
                            file.mkdirs();
                        }
                       /*
                          自定义一个文件的命名规则:防止同名的文件被覆盖
                          规则:域名+毫秒值+随机数
                        */
                        String fileName =  "hs_vae"+System.currentTimeMillis()+new Random().nextInt(999999)+"dog.jpg";
                        //5.创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
                        FileOutputStream fos=new FileOutputStream(file+"/"+fileName);
                        //6.使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
                        int len=0;
                        byte[] bytes=new byte[1024];
                        while ((len=is.read(bytes))!=-1){
                        //7.使用本地字节输出流FIleOutputStream对象中的方法write，把读取到的文件保存到服务器的硬盘上
                            fos.write(bytes,0,len);
                        }
                        //8.使用Socket对象中的方法getOutputStream，获取到网络字节输出流OutputStream对象
                        //9.使用网络字节输出流OutputStream对象中的方法write，给客户端回写"上传成功"
                        socket.getOutputStream().write("上传成功".getBytes());
                        //10.释放资源
                        fos.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();
        }
    }
}
```

服务器端的代码最后部署到服务器中，使用命令行运行，由于package有依赖可以使用Maven项目管理工具

这里只能实现图片的上传，还没有写通用版本，后续在更新！

## 结果截图

上传到我自己阿里服务器的/hs文件夹中

![](https://picture.hs-vae.com/文件上传结果截图.png)

由于我自己在/hs文件夹里面利用python开了一个8000端口网页，可以直接在网页上看到这个.jpg文件

![](https://picture.hs-vae.com/浏览器显示文件.png)