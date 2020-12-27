package com.hs_vae.Interface;
/*
      注意事项:不能通过接口实现类的对象来调用接口当中的静态方法
      正确用法:先在所在的类名称后面implements该接口,然后通过接口名称,直接调用其中的静态方法
      调用格式:
      接口名称:静态方法名(参数)
 */
public class Demo3Interface implements MyInterfaceStatic{
    public static void main(String[] args) {
        MyInterfaceStatic.sta();  //这是接口的静态方法
    }
}
