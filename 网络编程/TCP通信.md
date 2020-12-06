<!-- toc -->

## TCP通信的客户端

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

## TCP通信的服务器端  

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

