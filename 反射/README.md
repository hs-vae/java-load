<!-- toc -->

# 反射概念

反射：将类的各个组成部分封装为其他对象

反射机制允许程序在运行时借助Reflection API取得任何类的内部信息，并能直接操作对象的内部属性及方法

Java反射机制主要提供了以下功能：

1. 在运行时判断任意一个对象所属的类
2. 在允许时构造任意一个类的对象
3. 在允许时获取任意一个类所具有的成员变量和方法
4. 在允许时调用任意一个对象的方法
5. 生成动态代理

现在很多流行框架的基础，如Spring、Hibernate等都采用了反射机制，是框架设计的灵魂

Reflection API 提供了Constructor、FIled和Method类，这三个类都定义在java.lang.reflect包中，分别用于描述类的构造方法、成员变量、成员方法

# 获取Class对象的三种方式

1. Class.forName("全限定类名")：将字节码文件加载进内存，返回Class对象，多用于加载配置文件

```java
Class cls1 = Class.forName("Advanced.Reflect.Person");
System.out.println(cls1);  //class Advanced.Reflect.Person
```

2. 类名.class：通过类名的属性class获取，多用于参数的传递

```java
Class cls2 = Person.class;
System.out.println(cls2);  //class Advanced.Reflect.Person
```

2. 对象.getClass()：getClass()方法在Object类中定义，多用于对象的获取字节码的方式

```java
Person person = new Person();
Class cls3 = person.getClass();
System.out.println(cls3);  //class Advanced.Reflect.Person
```

同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，无论通过哪一种方式获取的Class对象都是同一个

```java
System.out.println(cls1.equals(cls2)); //true
```

# Class对象功能

## Filed类(获取成员变量们)

```java
获取成员变量们
Field[] getFields() 获取所有public修饰的成员变量
Field gerField(String name) 获取指定的public修饰的成员变量
Field[] getDeclaredFields() 获取所有的成员变量,不考虑修饰符
Field getDeclaredField(String name) 获取指定的成员变量，如果获取被private修饰时，要先使用setAccessible方法忽略访问权限修饰的安全问题
    
Field类的常用方法
  - String getName() 返回属性的名称
  - int getModifiers() 返回修饰符的整型标识
  - getXxx(Object obj) 获取属性的值
  - setXxx(Object obj,Xxx val) 设置属性的值
  - Class[] getType() 返回当前属性的类型
```

案例

Person类

```java
ppackage Advanced.Reflect;

public class Person {
    public String name;
    private int age;
    private int a;
    protected double sex;
    boolean flag;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                ", sex=" + sex +
                ", flag=" + flag +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
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

    public double getSex() {
        return sex;
    }

    public void setSex(double sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Person(String name, int age, double sex, boolean flag) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.flag = flag;
    }

    public Person() {
    }
    public void say(){
        System.out.println("该方法已执行!");
    }
    public void eat(String food){
        System.out.println(food);
    }
}
```

测试类

```java
package Advanced.Reflect;

import java.lang.reflect.Field;

public class Demo02Reflect {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取Person的Class对象
        Class personClass = Person.class;
        /*
             获取成员变量们
               Field[] getFields() 获取所有public修饰的成员变量
               Field gerField(String name)
               Field[] getDeclaredFields()
               Field getDeclaredField(String name)
         */
        // Field[] getFields() 获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------------------");
        // Field gerField(String name) 获取指定的public修饰的成员变量
        Field name = personClass.getField("name");
        Person person =new Person();
        Object o = name.get(person);
        System.out.println(o);     //null
        name.set(person,"许嵩");
        System.out.println(person); //Person{name='许嵩', age=0, a=0, sex=0.0, flag=false}
        System.out.println("------------------------");
        // Field[] getDeclaredFields() 获取所有的成员变量,不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("------------------------");
        // Field getDeclaredField(String name)
        Field age = personClass.getDeclaredField("age");
        //忽略访问权限修饰符的安全检查
        age.setAccessible(true);  //暴力反射
        Object o1 = age.get(person);
        System.out.println(o1);  //0
        age.set(person,10);
        System.out.println(person); //Person{name='许嵩', age=10, a=0, sex=0.0, flag=false}
    }
}
```

## Constructor类(获取构造方法们)

```java
获取构造方法们
Constructor<?>[] getConstructors()
Constructor<T>  getConstructor(类<?>....parameterTypes)
Constructor<?>[] getDeclaredConstructors()
Constructor<T> getDeclaredConstructor(类<?>....parameterTypes)
    
Constructor常用方法如下
 - String getName() 返回构造方法的名称
 - Class[]getParameterTypes() 返回当前构造方法的参数类型
 - intgetModifiers() 返回修饰符的整型标识,需要使用Modifier工具类的方法解码后才能获得真实的修饰符
```

案例需求：获取java.lang.String类的所有构造方法

```java
package Advanced.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
     案例:获取指定类的构造方法信息

     获取构造方法们
     Constructor<?>[] getConstructors()
     Constructor<T>  getConstructor(类<?>....parameterTypes)
     Constructor<?>[] getDeclaredConstructors()
     Constructor<T> getDeclaredConstructor(类<?>....parameterTypes)
     
     Constructor常用方法如下
      - String getName() 返回构造方法的名称
      - Class[]getParameterTypes() 返回当前构造方法的参数类型
      - intgetModifiers() 返回修饰符的整型标识,需要使用Modifier工具类的方法解码后才能获得真实的修饰符
 */
public class Demo03Constructor {
    public static void main(String[] args) {
        try {
            //获取String类对象
            Class stringClass = Class.forName("java.lang.String");
            //使用Constructor方法获取所有构造方法
            Constructor[] constructors = stringClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //获取构造方法的修饰符
                int modifiers = constructor.getModifiers();
                //使用Modifier工具类的方法获得真实的修饰符并输出
                System.out.print(Modifier.toString(modifiers));
                //获取构造方法的名称,并输出
                String name = constructor.getName();
                System.out.print(" "+name+"(");
                //获取构造方法的参数类型
                Class[] parameterTypes = constructor.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i>0){
                        System.out.print(",");
                    }
                    //输出类型名称
                    System.out.print(parameterTypes[i].getName());
                }
                System.out.println(");");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

```

输出结果

```java
public java.lang.String([B);
public java.lang.String([B,int,int);
public java.lang.String([B,java.nio.charset.Charset);
public java.lang.String([B,java.lang.String);
public java.lang.String([B,int,int,java.nio.charset.Charset);
 java.lang.String([C,int,int,java.lang.Void);
 java.lang.String(java.lang.AbstractStringBuilder,java.lang.Void);
public java.lang.String(java.lang.StringBuilder);
public java.lang.String(java.lang.StringBuffer);
 java.lang.String([B,byte);
public java.lang.String([C,int,int);
public java.lang.String([C);
public java.lang.String(java.lang.String);
public java.lang.String();
public java.lang.String([B,int,int,java.lang.String);
public java.lang.String([B,int);
public java.lang.String([B,int,int,int);
public java.lang.String([I,int,int);
```

使用构造器创建对象

```java
package Advanced.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo05Constructor {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        //使用有多个参数构造器创建对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor); //public Advanced.Reflect.Person(java.lang.String,int)
        Object vae = constructor.newInstance("许嵩", 34);
        System.out.println(vae);   //Person{name='许嵩', age=34, a=0, sex=0.0, flag=false}
    }
}
```

## Method类(获取成员方法们)

```java
获取成员方法们:
 - Method[] getMethods()   获取所有public修饰的成员方法
 - Method getMethod(String name,类<?>...parameterTypes) 获取指定的public修饰的成员方法
 - Method[] getDeclaredMethods()
 - Method  getDeclaredMethod(String name,类<?>...parameterTypes)
     
Method类的常用方法
 - String getName() 返回方法的名称
 - Class[] getParameterTypes()  返回当前方法的参数类型
 - int getModifiers() 返回修饰符的整型标识
 - Class getReturnType()  返回当前的返回值类型
```

案例：获取java.lang.String类的所有方法信息

```java
package Advanced.Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
     案例:获取String类的成员方法
     获取成员方法们:
        Method[] getMethods()   获取所有public修饰的成员方法
        Method getMethod(String name,类<?>...parameterTypes) 获取指定的public修饰的成员方法
        Method[] getDeclaredMethods()
        Method  getDeclaredMethod(String name,类<?>...parameterTypes)
     Method类的常用方法
        String getName() 返回方法的名称
        Class[] getParameterTypes()  返回当前方法的参数类型
        int getModifiers() 返回修饰符的整型标识
        Class getReturnType()  返回当前的返回值类型
 */
public class Demo04Method {
    public static void main(String[] args) {
        try {
            //获取String类对象
            Class clazz = Class.forName("java.lang.String");
            //返回所有public修饰的的成员方法
            Method[] mtd = clazz.getMethods();
            for (Method method : mtd) {
                //获取方法的修饰符
                int modifiers = method.getModifiers();
                //使用Modifier工具类的方法获得真实的修饰符,并输出
                System.out.print(Modifier.toString(modifiers));
                //获取方法的返回值类型,并输出
                Class returnType = method.getReturnType();
                System.out.print(" "+returnType.getName());
                //获取方法的名称,并输出
                System.out.print(" "+method.getName()+"(");
                //获取方法的参数类型
                Class[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i>0){
                        System.out.print(",");
                    }
                    //输出类型名称
                    System.out.print(parameterTypes[i].getName());
                }
                System.out.println(");");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

执行方法等操作

```java
package Advanced.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo06Method {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class personClass = Person.class;
        //获取空参的成员方法
        Method say = personClass.getMethod("say");
        //执行方法
        Person person = new Person();
        say.invoke(person);
        //获取实参的成员方法
        Method eat = personClass.getMethod("eat", String.class);
        eat.invoke(person,"吃西瓜");
        String name = personClass.getName(); //获取类名
        System.out.println(name); //Advanced.Reflect.Person
    }
}
```

