package com.hs_vae.Experiment.Demo1;
/*
      实验一基本任务：
            1.打印排名前十IP地址
            2.输出不同的"ERROR"异常信息
            3.对象序列化
 */

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





