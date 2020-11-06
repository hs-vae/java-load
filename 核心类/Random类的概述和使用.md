概述：

```java
package Demo2;
//Date:2020.10.11
/*

 * Random类作用:定义一个变量n,可以随机生成一个[0,n)的数
   */
   import java.util.Random;                //导包
   public class Demo7Random {
   public static void main(String[] args) {
   Random a=new Random();
   int num =a.nextInt(2);                  //会在[0,2)之间生成一个数并且赋值给num
   System.out.println("随机生成的一个数为:"); //0或1
   System.out.println(num);

}
}
```

定义一个随机变量n,利用Random类获取[1,n]之间随机产生的数值:

```java
package Demo2;
import java.util.Random;
//Date:2020.10.11       
/*

 * 练习:定义一个随机变量,利用Random获取[1,n]的值
   */
   public class Demo8Random1 {
   public static void main(String[] args) {
   	int n=5;
   	Random a=new Random();
   	for(int i=0;i<100;i++) {
   				int result=a.nextInt(n)+1;  //方法加1可以实现整体[0,n)区间向后挪一位,变成[1,n]
   				System.out.println("在[1,n]区间内随机输出的值是:"+result);
   	}
   }
}
```



猜数字的小游戏:

```java
package Demo2;
import java.util.Scanner;
import java.util.Random;
//Date:2020.10.11
/*猜数字小游戏,在[1,100]随机生成一个数字n，然后键盘输入一个数字,直到两个数字相等,及猜对,游戏结束.

 * 首先随机生成一个数字randomNum，键盘输入一个数字guessNum
 * 分为3种情况:
 * randomNum>guessNum:太小了,请重试
 * randomNum<guessNum:太大了,请重试
 * randomNum=guessNum:猜中,游戏结束
   */
   public class Demo9RandomGame {
   public static void main(String[] args) {
   	Random a=new Random();
   	int randomNum=a.nextInt(100)+1;
   	while(true) {   //不明确循环次数时候用while
   		System.out.println("请输入一个数:");
   		Scanner b=new Scanner(System.in);
   		int guessNum=b.nextInt();
   		if(randomNum>guessNum) {
   			System.out.println("太小了，重新输入:");
   		}else if(randomNum<guessNum) {
   			System.out.println("太大了,重新输入:");
   		}else {
   			System.out.println("恭喜你,猜对了!");
   		}
   	}
   }
   }
```

