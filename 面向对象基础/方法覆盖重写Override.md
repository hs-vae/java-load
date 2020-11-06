<!-- toc -->

## 一、概念与特点

概念:在继承关系当中,方法的名称一样,参数列表也一样

特点:创建的是子类对象,则优先用子类对象

## 二、注意事项

方法覆盖重写的注意事项:

​     　　1.必须保证父子类之间方法的名称相同,参数列表也相同.
​     　　@Override:卸载方法前面,用来检测是不是有效的正确覆盖重写
​     　　这个注释不写只要满足要求也是正确的,最好写因为可以提醒自己

​    　　 2.子类方法的返回值必须小于等于父类方法的返回值范围
​             扩展:java.lang.Object类是所有类的公共最高父类(祖宗类),String就是子类

​    　　 3.子类方法的权限必须大于等于父类方法的权限修饰符
​             扩展: public > protected > (default) > private
​             注意:　(default)不是关键字default,而是什么都不写,留空

## 三、应用场景(手机案例)

```java
//Phone.java
package Basis.Demo7Extends.Demo4;
// 老款手机
public class Phone {
    public void call(){
        System.out.println("打电话");
    }
    public void send(){
        System.out.println("发短信");
    }
    public void show(){
        System.out.println("显示号码");
    }
}

//NewPhone.java
package Basis.Demo7Extends.Demo4;
//  定义一个新手机,继承了老手机,作为父类
public class NewPhone extends Phone{
    @Override
    public void show() {
        super.show();     //可以使用super获取父类中show方法
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}

//Demo1Phone.java
package Basis.Demo7Extends.Demo4;
public class Demo1Phone {
    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("-----------------------");
        NewPhone newPhone=new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}

//输出结果
打电话
发短信
显示号码
-----------------------
打电话
发短信
显示号码
显示姓名
显示头像
```

