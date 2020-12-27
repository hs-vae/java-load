package com.hs_vae.Extends.Demo2;

/*
        在继承的关系中,"子类就是一个父类",也就是说,子类可以被当做父类看待
        例如父类是员工,子类是助教,那么"助教就是一个员工",关系: is-a

        定义父类的格式:(一个普通的类定义)
        public class 父类名称{
                 ...
        }

        定义子类的格式:(多了extends 父类名称)
        public class 子类名称 extends 父类名称{
                  ...
        }
 */
public class Demo1Extends {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.method();
        Assistant assistant=new Assistant();
        assistant.method();
    }
}
