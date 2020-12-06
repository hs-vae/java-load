# 一、线程是什么？

在计算机中当一个程序运行的时候就会创建至少一个进程，例如当我们运行QQ的时候，系统就会创建进程来处理我们平时的一些操作，当我们打开任务管理器的时候，在进程的列表里面就可以找到QQ.exe的运行程序；

在计算机中处理进程之外还有另一个概念就是线程，线程是存在于进程当中，一个进程可以包含多个线程;当我们的计算机有多核处理器的时候，使用多线程可以加快程序的运算速率;如果一个进程中只有一个线程，当程序遇到一个比较耗时的计算的时候，由于程序是单线程的，那么程序只能等待这个运算结束的时候再继续运行，这样会大大的降低程序的效率;当时用多个线程的时候，在某个线程遇到比较耗时的运算的时候，该线程可以继续自己的运算，但是其他的线程也可以同步进行，这样当耗时的计算结束之后，其他线程也将自己所需要的东西执行完毕，这样就会很大的提高程序执行效率；

在程序运行中对于文件的保存相对于处理器的运算速度来说是很慢的，当我们程序中接收到一个保存文件的信息之后，我们可以创建一个保存文件的线程，在主线程中我们可以继续进行我们的其他运算，这样当文件保存好之后，我们的其他运算也会完成，互不影响；

在Java中我们可以创建一个自己的类继承于Thread类，并且重写run() 方法，当线程启动之后，run()方法里面的操作都在线程中进行处理，而不会影响主线程的信息；

当我们创建好一个自定义线程类之后，我们可以创建这个自定义线程的对象，进行线程的启动;线程须调用start();方法进行启动，这样run()方法里面的内容才会在线程中运行;如果我们不去调用start()方法，那我们只是创建了一个普通的类，即使我们手动调用run()方法，run()方法里面的内容也不会在线程中运行；

在Java中线程主要有初始状态，运行状态，阻塞状态，终止状态等;当我们新创建一个线程对象的时候，此时线程的状态为初始状态;当我们调用start()之后，此时的线程才被激活成为运行状态，之后run()方法里面的信息才会在子线程中运行;我们可以在不同的阶段调用不同的方法将线程设置为不同的状态;比如有时候我们的操作需要等待其他线程中运算结束之后才可以继续进行，这时候我们就可以将线程设置为等待状态，当需要的资源满足条件之后，可以继续运行当前的线程

# 二、多线程的两种创建方式

## ①继承Thread类

创建多线程程序的第一种方式:继承Thread类,创建Thread类的子类

java.lang.Thread类:是描述线程的类,我们想要实现多线程程序,就必须继承Thread类

### 实现步骤:

1.创建一个Thread类的子类

2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(即开启线程要做什么)

3.创建Thread类的子类对象

4.调用Thread类中的方法start方法,开启新的线程,执行run方法

      void start() 使该线程开始执行,java虚拟机调用该线程的run方法
      结果是两个线程并发的运行:当前线程(main线程)和另一个线程(创建的新线程,执行其run方法)
      多次启动一个线程是非法的,特别是当线程已经结束执行后,不能再重新启动

### 代码实现:

```java
package Advanced.Thread;

public class Demo02Thred {

    public static void main(String[] args) {
        // 3.创建Thread类的子类对象
        Mythread th=new Mythread();
        th.setName("hs");
        // 4.调用Thread类中的方法start方法,开启新的线程,执行run方法
        th.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
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

## ②实现Runnable接口

### Runnable接口介绍

创建多线程程序的第二种方式:  实现Runnable接口
java.lang.Runnable
   Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为run 的无参数方法
java.lang.Thread类的构造方法
   Thread(Runnable target) 分配新的Thread对象
   Thread(Runnable target, String name) 分配新的Thread对象

### Runnable接口实现步骤

1.创建一个Runnable接口的实现类

2.在实现类中重写Runnable接口的run方法,设置线程任务

3.创建一个Runnable接口的实现类对象

4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象

5.调用Thread类中的start方法,开启新的线程运行run方法

### 实现Runnable接口好处

1.避免了单继承的局限性

   一个类只能继承一个类,类继承了Thread类就不能继承其他的类

   实现了Runnable接口,还可以继承其他的类,实现其他的接口

2.增强了程序的扩展性,降低了程序的耦合性(解藕)

   实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解藕)

   实现类中,重写了run方法,用来设置线程任务

   创建Thread类对象,调用start方法,用来开启新线程

代码实现

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

# 三、Thread类的常用方法

## 1.获取线程的名称

1.使用Thread类中的方法getName()

   String getName(),返回该线程的名称.

2.可以先获取到当前正在执行的线程,使用线程中的方法getName()获取线程的名称

   static Thread currentThread() 返回对当前正在执行的线程对象的引用

## 2.设置线程的名称

1.使用Thread类中的方法setName(名字)
  void setName(String name)改变线程名称,使之与参数name相同
2.创建一个带参数的构造方法,参数传递线程的名称,调用父类的带参构造方法,把线程名称传递给父类,让父类给子线程取一个名字
  Thread(String name) 分配新的Thread对象

## 3.指定线程暂停的时间

public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停(暂停停止时间)，毫秒数结束之后,线程继续执行

代码实现

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

# 四、匿名内部类方式实现线程创建

## 匿名内部类概述

匿名内部类方式实现线程的创建

匿名:没有名字  内部类:写在其他类内部的类

匿名内部类的作用:简化代码

1.把子类继承父类,重写父类的方法,创建子类对象合成一步完成

2.把实现类实现类接口,重写接口中的方法,创建实现类对象合成一步完成

匿名内部类的最终产物:子类/实现类对象,而这个类没有名字

格式:

new 父类/接口(){
       重写父类/接口的方法

};

代码实现

```java
package Advanced.Thread;
//匿名内部类方式实现线程的创建
public class Demo04InnerClassThread {
    public static void main(String[] args) {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();

    }
}
```

# 五、线程安全问题及其解决方法

## 线程安全问题产生的原因

![](https://img-blog.csdnimg.cn/img_convert/c67d2e1e01bcbc10fd5ed643ceb92e72.png)

安全问题代码举例

```java
package Advanced.Thread;
/*
   线程安全问题代码实现(电影院卖票案例)
 */
public class Demo05ThreadSafe {
    public static void main(String[] args) {
        RunnbaleImpl run=new RunnbaleImpl();
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
class RunnbaleImpl implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                ticket--;
            }
        }

    }
}

```

出现了重复的票，出现了安全问题!

![](https://img-blog.csdnimg.cn/img_convert/af99e3e8cb8379781939c43e70acc786.png)

## 解决线程安全问题三种方式

为了保证每个线程都能正常执行原子操作，java引入了线程同步机制

有三种方式完成同步操作：

1. 同步代码块

2. 同步方法

3. 锁机制

### 1. 同步代码块

卖票问题出现了线程安全问题

卖出了不存在的票和重复的票

解决线程安全问题的第一种方案：使用同步代码块

格式：

```
   synchronized(锁对象){
       可能会出现线程安全问题的代码(访问了共享数据的代码)
   }
```

注意：

1. 通过代码块中的锁对象，可以使用任意的对象，例如Object类对象

2. 但是必须保证多个线程使用的锁对象是同一个

3. 锁对象的作用：把同步代码块锁住，只让一个线程在同步代码块中执行

```java
package Advanced.Thread;
/*
   线程安全问题代码实现(电影院卖票案例)
 */
public class Demo05ThreadSafe {
    public static void main(String[] args) {
        RunnbaleImpl run=new RunnbaleImpl();
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
class RunnbaleImpl implements Runnable{
    private int ticket=100;
    Object obj=new Object();  //创建一个Object类对象，当做锁对象
    @Override
    public void run() {
        while (true){
            synchronized (obj){  //使用synchronized同步代码块
                if(ticket>0){
                    try {
                        Thread.sleep(1000); //让它睡眠1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }

    }
}
```

#### 同步技术原理

```java
public class Demo05ThreadSafe {
    public static void main(String[] args) {
        RunnbaleImpl run=new RunnbaleImpl();
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
```

3个线程t1，t2，t3一起抢夺cpu的执行权，谁抢到了谁执行run方法进行卖票

假设t1抢到了cpu的执行权，执行run方法，遇到synchronized代码块

这时t1会检查synchronized代码块是否有锁对象(上述的obj)

如果有，就会获取到锁对象，进入到同步执行

这时候t2也抢到了cpu执行权但是没有检查到锁对象，

那么t2就会进入阻塞状态，会一直等待t1线程归还锁对象，

一直到t1线程执行完同步中的代码，

会把对象归还给synchronized代码块

t2才能获取到锁对象进入到同步中执行

总结：同步中的线程，没有执行完毕不会释放锁，同步外的线程没有锁进不去同步

同步保证了只能有一个线程在同步中执行共享数据

### 2. 同步方法

卖票问题出现了线程安全问题

卖出了不存在的票和重复的票

解决线程安全问题的第二种方案：使用同步方法

格式：

定义方法的格式

```java
 修饰符 synchronized 返回值类型 方法名(参数列表){
     可能会出现线程安全问题的代码(访问了共享数据的代码)
 }
```

代码实现

```java
//RunnableImpl Runnable接口实现类
package Advanced.Thread.Synchronized;

public class RunnableImpl implements Runnable{
    //定义一个多个线程共享的票源
    private int ticket=100;
    //设置线程任务:卖票
    @Override
    public void run() {
        while (true){
              payTicket();
        }
    }
   
    //定义同步方法
    public synchronized void payTicket(){
      //使用死循环,让卖票重复操作执行
       while(true){
        //先判断票是否存在
        if(ticket>0){
            try {
                //提高安全问题出现的概率,让程序睡眠
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果票存在,卖票ticket
            System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
            ticket--;
        }
       }
    }
}


//Demo01Ticket 主类
package Advanced.Thread.Synchronized;

public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run=new RunnableImpl();
        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        //调用start方法开启多线程
        t1.start();
        t2.start();
        t3.start();
    }
}
```

### 3. Lock锁

卖票问题出现了线程安全问题

卖出了不存在的票和重复的票

解决线程安全问题的第三种方案：使用Lock锁

java.util.concurrent.locks.Lock接口

Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作

Lock 接口中的方法：

 void lock() 获取锁

 void unlock() 释放锁

java.util.concurrent.locks.ReentrantLock implements Lock 接口

使用步骤:

1. 在成员位置创建一个ReentrantLock 对象
2. 在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁
3. 在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁

代码实现:

```java
//RunnableImpl Runnable接口实现类
package Advanced.Thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable{
    //定义一个多个线程共享的票源
    private int ticket=100;
    //1.在成员位置创建一个ReentrantLock对象
     Lock l=new ReentrantLock();  //使用多态
    //设置线程任务:卖票
    @Override
    public void run() {
        while (true){
            //使用死循环,让卖票重复操作执行
            while(true){
                //2.在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁
                l.lock();
                //先判断票是否存在
                if(ticket>0){
                    try {
                        //提高安全问题出现的概率,让程序睡眠
                        Thread.sleep(10);
                        //如果票存在,卖票ticket
                        System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
                        l.unlock();   //无论是否出现异常,都释放锁
                    }

                }

            }

        }
    }
}


//Demo01Ticket 主类
package Advanced.Thread.Lock;

public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run=new RunnableImpl();
        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        //调用start方法开启多线程
        t1.start();
        t2.start();
        t3.start();
    }
}
```

# 六、线程通信

## 等待唤醒案例:线程之间的通信

![](https://img-blog.csdnimg.cn/img_convert/655521c2ea93358370a749c072a61a9f.png)

### 等待唤醒代码实现

   创建一个顾客线程(消费者)：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进入到Waiting状态(无限等待)

   创建一个老板线程(生产者)：花了3秒做包子，做好包子之后调用notify方法，唤醒顾客吃包子

 注意：

1. 顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
2. 同步使用的锁对象必须保证唯一
3. 只有锁对象才能调用wait和notify方法

 Object类(不带参数)的方法

1. void wait()  

   在其他线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待

2. void notify()

   唤醒在此对象监听器上等待的单个线程，之后会继续执行wait方法之后的代码

进入到TimeWaiting(计时等待)有两种方式

1. 使用sleep(long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态

2. 使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来

唤醒的方法:

1. void notify() 唤醒在此对象监听器上等待的单个线程

2. void notifyAll() 唤醒在此对象监听器上等待的所有线程

```java
package Advanced.Thread.WaitAndNotify;

public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建一个锁对象
        Object obj=new Object();
        // 创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("告知老板要的包子种类和数量");
                    try {
                        //调用wait方法，放弃cpu的执行，进入到Waiting状态(无限等待)
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //唤醒之后的代码
                System.out.println("拿到包子准备开吃!");
            }
        }.start();

        // 创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        //花了3秒钟做包子
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子已经做好可以过来取了");
                    //调用notify方法，唤醒顾客吃包子
                    obj.notify();
                }
            }
        }.start();
    }
}

```

## 等待唤醒机制其实就是经典的"生产者与消费者"问题

拿生生产包子消费包子案例来说等待唤醒机制如何有效利用资源

包子铺线程生产包子，吃货线程消费包子，当包子没有时(包子状态为false)，吃货线程等待，包子铺线程生产包子(即包子状态为true)，并通知吃货线程(解除吃货的等待状态)，因为已经有包子了，那么包子铺线程进入等待状态。接下来，吃货线程能否进一步执行则取决于锁的获取情况。如果吃货获取到锁，那么就执行吃包子动作，包子吃完后包子状态为false，并通知包子铺线程解除包子铺的等待状态，吃货线程进入等待，包子铺线程能否进一步执行则取决于锁的获取情况

**包子资源类**

```java
package Advanced.Thread.WaitAndNotify;
/*
   资源类:包子类
   设置包子的属性
     皮
     陷
     包子的状态：有true，没有false
 */
public class BaoZi {

    String pi;   //皮
    String xian; //陷
    boolean flag=false;  //包子的状态，初始值为false
}
```

**生产者(包子铺)类**

生产者(包子铺)类:是一个线程类，可以继承Thread类
设置线程任务(run):生产包子
对包子的状态进行判断
true:有包子
   包子铺调用wait方法进入等待状态
false:没有包子
   包子铺生产包子
   交替生产两种包子,有两种状态(count%2==0)
   包子铺生产好了包子
   修改包子的状态为true有
   唤醒吃货线程，让吃货线程吃包子
注意:
   包子铺线程和包子线程关系-->通信(互斥)
   必须同时使用同步技术保证两个线程只有一个在执行
   锁对象必须是保证唯一，可以使用包子对象作为锁对象
   包子铺类和吃货类就需要把包子对象作为参数传递进来
      1.需要在成员位置创建一个包子变量
      2.使用带参数构造方法，为了这个包子变量赋值

```java
package Advanced.Thread.WaitAndNotify;

public class BaoZiPu extends Thread{
    // 在成员变量位置创建一个包子变量
    private BaoZi bz;

    // 使用带参数构造方法,为这个包子变量赋值
    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务(run):生产包子
    @Override
    public void run() {
        //定义一个变量
        int count=0;
        //让包子铺一直做包子
        while (true){
            synchronized (bz){
                if (bz.flag==true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //没有包子,包子铺生成包子
                if (count%2==0){
                    bz.pi="薄皮";
                    bz.xian="香菇白菜陷";
                }else{
                    bz.pi="凉皮";
                    bz.xian="猪肉韭菜陷";
                }
                count++;
                System.out.println("包子铺正在做:"+bz.pi+bz.xian+"包子");
                //做包子需要3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改包子的状态为true
                bz.flag=true;
                //做好包子唤醒吃货
                bz.notify();
                System.out.println("包子铺已经做好了"+bz.pi+bz.xian+"包子");
            }
        }
    }
}
```

**消费者(吃货)类**

   消费之(吃货)类：是一个线程类,可以继承Thread
   设置线程任务(run)：吃包子
   对包子的状态进行判断
   false:没有包子
     吃货调用wait方法进入等待状态
   true:有包子
     吃货吃包子
     吃货吃完包子
     修改包子的状态为false没有
     吃货唤醒包子铺线程,生产包子

```java
package Advanced.Thread.WaitAndNotify;

public class ChiHuo extends Thread{
    // 在成员变量位置创建一个包子变量
    private BaoZi bz;

    // 使用带参数构造方法,为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务(run)：吃包子
    @Override
    public void run() {
        //使用死循环一直吃包子
        while (true){
            synchronized (bz){
                if (bz.flag==false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃"+bz.pi+bz.xian+"包子");
                //吃货吃完包子后修改包子状态为false
                bz.flag=false;
                //唤醒包子铺去做包子
                bz.notify();
                System.out.println("吃货已经吃完"+bz.pi+bz.xian+"包子,包子铺开始做包子");
                System.out.println("------------------------------------------");
            }
        }
    }
}
```

**测试类**

```java
package Advanced.Thread.WaitAndNotify;

public class Demo {
    public static void main(String[] args) {
        //创建包子对象
        BaoZi bz=new BaoZi();
        //创建包子铺线程,开启生产包子
        new BaoZiPu(bz).start();
        //创建吃货线程,开启吃包子
        new ChiHuo(bz).start();
    }
}

```

**输出结果**

```java
包子铺正在做:薄皮香菇白菜陷包子
包子铺已经做好了薄皮香菇白菜陷包子
吃货正在吃薄皮香菇白菜陷包子
吃货已经吃完薄皮香菇白菜陷包子,包子铺开始做包子
------------------------------------------
包子铺正在做:凉皮猪肉韭菜陷包子
包子铺已经做好了凉皮猪肉韭菜陷包子
吃货正在吃凉皮猪肉韭菜陷包子
吃货已经吃完凉皮猪肉韭菜陷包子,包子铺开始做包子
------------------------------------------
```

# 七、线程池

## 线程池的概念和原理

如果并发的线程数量很多，并且每个线程都是执行一个时间很短的任务就结束了，这样频繁创建线程就会大大降低系统的效率，可以通过线程池使得线程可以复用，执行完每一个任务后，并不被销毁，可以继续执行其他的任务

线程池其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁的创建线程对象的操作，无需反复创建线程而消耗过多资源

![](https://img-blog.csdnimg.cn/img_convert/0d2a0b6856d160dd442b4250e162b4c4.png)

## 线程池的代码实现

java.util.concurrent.Executors:线程池的工厂类,用来生成线程池

Executors类中的静态方法:
   static ExecutorService newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池
   参数:
      int nThread:创建线程池中包含的线程数量
   返回值:
      ExecutorService接口,返回的是ExecutorService接口的实现类对象,可以使用ExecutorService接口接收

java.util.concurrent.ExecutorService:线程池接口
  用来从线程池中获取线程,调用start方法,执行线程任务
     submit(Runnable task) 提交一个Runnable 任务用于执行
  关闭/销毁线程池的方法
     void shutdown()

### 线程池的使用步骤:

1. 使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程
2. 创建一个类,实现Runnable接口,重写run方法,设置线程任务
3. 调用ExecutorService中的方法submit,传递线程任务(实现类),开启线程,执行run方法
4. 调用ExecutorService中的方法shutdown销毁线程池

**Runnable接口实现类**

```java
package Advanced.Thread.ThreadPool;
//2.创建一个类,实现Runnable接口,重写run方法,设置线程任务
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开启了线程任务!");
    }
}

```

**测试类**

```java
package Advanced.Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3.调用ExecutorService中的方法submit,传递线程任务(实现类),开启线程,执行run方法
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        //4.调用ExecutorService中的方法shutdown销毁线程池
        es.shutdown();
    }
}

```

**输出结果**

```java
pool-1-thread-2开启了线程任务!
pool-1-thread-1开启了线程任务!
pool-1-thread-1开启了线程任务!

Process finished with exit code 0
```
