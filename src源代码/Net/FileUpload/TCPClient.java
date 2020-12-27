package com.hs_vae.Net.FileUpload;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis=new FileInputStream("/home/hs/dog");
        //2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket=new Socket("localhost",8000);
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
