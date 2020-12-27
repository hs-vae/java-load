package com.hs_vae.Demo1;
/*
 1.定义位置不一样:
 局部变量:在方法内部
 成员变量：在方法外部
 2.作用范围不一样：
 局部变量：只有方法当中才可以使用，出了方法就不能使用
 成员变量：整个类全都可以使用
 3.默认值不一样
 局部变量：没有默认值，如果想要使用必须手动赋值
 成员变量：如果没有赋值会有默认值的
 4.内存位置不一样
 局部变量：位于栈内存
 成员变量：位于堆内存
 */
public class Demo4VariableDifference {
        String name;  //成员变量 
        
        
        public void methodA() {
        	int num=0;  //局部变量,不赋值会报错的
        	System.out.println(num);
        }
        
        public void methodB(int param) {  //param也是局部变量，而且可以不用赋值，因为调用它时候一定要赋值
        	
        	System.out.println(param); 
        }
}
