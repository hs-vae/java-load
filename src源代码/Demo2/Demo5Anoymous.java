package com.hs_vae.Demo2;
//匿名对象
public class Demo5Anoymous {
	public static void main(String[] args) {
		new Person().name="迪丽热巴";
		new Person().showName();  //此时打印的不是"迪丽热巴",因为这是第二个对象,String默认值是null，所以输出的是null
	}

}
