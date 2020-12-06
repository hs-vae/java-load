<!-- toc -->

## Runnable接口介绍

创建多线程程序的第二种方式:  实现Runnable接口
java.lang.Runnable
   Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为run 的无参数方法
java.lang.Thread类的构造方法
   Thread(Runnable target) 分配新的Thread对象
   Thread(Runnable target, String name) 分配新的Thread对象

## Runnable接口实现步骤

1.创建一个Runnable接口的实现类
2.在实现类中重写Runnable接口的run方法,设置线程任务
3.创建一个Runnable接口的实现类对象
4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
5.调用Thread类中的start方法,开启新的线程运行run方法

## 实现Runnable接口好处

1.避免了单继承的局限性
   一个类只能继承一个类,类继承了Thread类就不能继承其他的类
   实现了Runnable接口,还可以继承其他的类,实现其他的接口
2.增强了程序的扩展性,降低了程序的耦合性(解藕)
   实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解藕)
   实现类中,重写了run方法,用来设置线程任务
   创建Thread类对象,调用start方法,用来开启新线程

## 代码实现

```java
public class Demo03Runnable {
    public static void main(String[] args) {
        // 3.创建一个Runnable接口的实现类对象
        ThreadTask task=new ThreadTask();
        // 4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t=new Thread(task);
        // 5.调用Thread类中的start方法,开启新的线程运行run方法
        t.start();

        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

// 1.创建一个Runnable接口的实现类
class ThreadTask implements Runnable{
    // 2.在实现类中重写Runnable接口的run方法,设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

