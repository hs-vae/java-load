package com.hs_vae.LanQiaoTest;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo02RandomFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("randomAccess.file");
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len= fis.read(bytes))!=-1){
            System.out.println(new String(bytes,10,len));
        }
    }
}
