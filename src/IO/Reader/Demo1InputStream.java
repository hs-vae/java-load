package com.hs_vae.IO.Reader;
import java.io.FileInputStream;
import java.io.IOException;
public class Demo1InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("hello.txt");
        int len=0;
        while((len=fis.read())!=-1){
            System.out.println(len);
        }
        fis.close();
    }
}
