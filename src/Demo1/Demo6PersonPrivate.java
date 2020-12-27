package com.hs_vae.Demo1;

//Date:2020.10.8
public class Demo6PersonPrivate {
	public static void main(String[] args) {
		Person a=new Person();
		a.name="许嵩";
        a.show();
        
        /*a.age=(20);   因为age被private所修饰不能直接访问，只能间接访问，可以利用方法进行访问*/

        a.setAge(-20);   //-20为不合理的数字，因为setAge方法里面有判断年龄合理，所以输出数据错误,这样private起到了约束的作用
        a.show();
        
        a.setAge(20);
        a.show();
        
	}
}
