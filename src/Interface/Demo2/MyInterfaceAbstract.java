package com.hs_vae.Interface.Demo2;

public  abstract class MyInterfaceAbstract implements MyInterfaceA,MyInterfaceB{
    @Override
    public void method(){
          System.out.println("覆盖重写了抽象方法");
    }


    @Override
    public void methodDefault() {
        System.out.println("对多个接口当中冲突的默认方法进行了覆盖重写");
    }

}
