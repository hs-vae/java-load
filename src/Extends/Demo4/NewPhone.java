package com.hs_vae.Extends.Demo4;
//  定义一个新手机,继承了老手机,作为父类
public class NewPhone extends Phone{
    @Override
    public void show() {
        super.show();     //可以使用super获取父类中show方法
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
