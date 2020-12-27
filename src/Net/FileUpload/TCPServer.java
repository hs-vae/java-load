package com.hs_vae.Net.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class
TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务器ServerSocket对象
        ServerSocket server=new ServerSocket(8000);
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
                        File file=new File("/home/hs/桌面");
                        if (!file.exists()){
                            file.mkdirs();
                        }
                       /*
                          自定义一个文件的命名规则:防止同名的文件被覆盖
                          规则:域名+毫秒值+随机数
                        */
                        String fileName ="hs_vae"+System.currentTimeMillis()+new Random().nextInt(999999)+"dog.jpeg";
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
