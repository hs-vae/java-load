package com.hs_vae.Net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
        Socket socket=new Socket("hs-vae.com",8080);
        //2.使用Socket对象中的方法getOutputStream() 获取网络字节输出流OutputStream对象
        OutputStream os=socket.getOutputStream();
        //3.使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
        os.write("阿坚牛逼!".getBytes());
        //4.使用Socket对象中的方法getInputStream() 获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6.释放资源(Socket)
        socket.close();
    }
}
