<!-- toc -->

### 获取线程的名称

1.使用Thread类中的方法getName()

   String getName(),返回该线程的名称.

2.可以先获取到当前正在执行的线程,使用线程中的方法getName()获取线程的名称

   static Thread currentThread() 返回对当前正在执行的线程对象的引用

## 设置线程的名称

1.使用Thread类中的方法setName(名字)
  void setName(String name)改变线程名称,使之与参数name相同
2.创建一个带参数的构造方法,参数传递线程的名称,调用父类的带参构造方法,把线程名称传递给父类,让父类给子线程取一个名字
  Thread(String name) 分配新的Thread对象

## 指定线程暂停的时间

public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停(暂停停止时间)，毫秒数结束之后,线程继续执行

## 代码实现

```java
public class Demo02Thred {

    public static void main(String[] args) {
        // 3.创建Thread类的子类对象
        Mythread th=new Mythread();
        // 设置线程名字
        th.setName("hs");
        // 4.调用Thread类中的方法start方法,开启新的线程,执行run方法
        th.start();
        for (int i = 0; i < 10; i++) {
            // 获取当前正在执行的线程名字
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                //让每个线程休眠一秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 1.创建一个Thread类的子类
class Mythread extends Thread{
    // 2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(即开启线程要做什么)
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName()+":"+i);
        }
    }
}
```

