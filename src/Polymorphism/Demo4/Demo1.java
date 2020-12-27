package com.hs_vae.Polymorphism.Demo4;
/*
      对象的向上转型，其实就是多态写法:
      父类名称 对象名 = new 子类名称();
      右侧创建了一个子类对象，把它当做父类来看待使用
      注意事项:向上转型一定是安全的,从小范围转向了大范围，从小范围的猫，向上转换成为更大范围的动物
 */
public class Demo1 {
    public static void main(String[] args) {
        Animal vae=new Cat();
        vae.eat();   
        if(vae instanceof Cat){
             Cat cat=(Cat)vae;
             cat.run();
        }

    }
}
