<!-- toc -->

## 一、Static修饰成员变量

### 1.主类

```java
package Basis.Demo5Static;
/*
      如果一个成员变量使用了static关键字,那么这个变量不再属于对象自己
     而是属于所在的类,多个对象共享同一份数据
 */
public class Demo1StaticFileld {
    public static void main(String[] args) {
        Student one=new Student("lz",20);
        one.room="观7-251";
        System.out.println("姓名是:"+one.getName()+",年龄是:"+one.getAge()+
                ",教室是:"+one.room+",学号是:"+one.getId());
        Student two=new Student("hs",20);
        System.out.println("姓名是:"+two.getName()+",年龄是:"+two.getAge()+
                ",教室是:"+two.room+",学号是:"+two.getId());
    }
}

```

### 2.Student类

```java
package Basis.Demo5Static;

public class Student {
    private int id;
    private String name;
    private int age;
    static String room;
    private static int idCounter=0; //学号计数器,每当new了一个新对象的时候,计数器++

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id=++idCounter;
    }

    public Student() {
        this.id=++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        Student.room = room;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Student.idCounter = idCounter;
    }
}

```

## 二、Static修饰成员方法

### 1.主类

```java
package Basis.Demo5Static;
/*
     一旦使用了static修饰成员方法,那么这就成为了静态方法,静态方法不属于对象,而是属于类的

     如果没有static关键字,那么必须首先创建对象,然后通过对象才能使用成员方法
     如果有static关键字,那么不需要创建对象,直接通过类名称来使用它

     无论是成员变量,还是成员方法,如果有了static,都推荐使用类名称进行调用
     静态变量:类名称.静态变量
     静态方法:类名称.静态方法

     注意:
     1.静态不能直接访问非静态,因为在内存当中先有的静态内容,后有非静态的内容
     2.静态方法当中不能用this
 */
public class Demo2StaticMethod {
    public static void main(String[] args) {
        //首先创建对象
        MyClass one=new MyClass();
        //然后才能使用没有static修饰的内容
        one.Method();

        //对于静态方法来说,可以通过对象名进行调用,也可以直接通过类名称来调用
        one.StaticMethod();      //可以这样写但是不推荐
        MyClass.StaticMethod();
    }
}

```

### 2.MyClass类

```java
package Basis.Demo5Static;

public class MyClass {
    int num;
    static int numStatic;
    public void Method(){
        System.out.println("这是一个成员方法");
        System.out.println(num);
        System.out.println(numStatic);
    }
    public static void StaticMethod(){
        System.out.println("这是一个静态方法");
        System.out.println(numStatic);
        //System.out.println(num);  //不能访问非静态的成员变量
        //System.out.println(this);  //不能使用this
    }
}

```

## 三、静态代码块

### 1.主类

```java
package Basis.Demo5Static;
/*
    静态代码块的格式:
      public class 类名称{
        static {
         //静态代码块内容
        }
      }
特点:当第一次用到本类时,静态代码块执行唯一的一次
静态内容总是优先于非静态,所以静态代码块比构造方法先执行
 */
public class Demo3Static {
    public static void main(String[] args) {
        Person one=new Person();
        Person two=new Person();
        
        /*
              执行结果:
                静态代码块执行！   (只执行了一次)
                构造方法执行   
                构造方法执行
                
         */        
    }
}
```

### 2.Person类

```java
package Basis.Demo5Static;

public class Person {
    static{
        System.out.println("静态代码块执行！");
    }
    public Person(){
        System.out.println("构造方法执行");
    }
}

```

