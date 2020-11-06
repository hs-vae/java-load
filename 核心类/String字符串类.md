<!-- toc -->

程序当中所有的双引号字符串,都是String类的对象(就算没有new,也照样是)，而且字符串的内容永远都不会变,字符串的效果相当与是char []字符串数组

对于引用类型来说,==进行的是地址值的比较,双引号直接写的字符在常量池当中，new的不在池当中.

## 一、字符串比较的相关方法

```java
package Basis.Demo4String;
/*
    字符串比较的相关方法

    ==是进行对象的地址值比较,如果确实需要字符串的内容比较,可以使用两个方法

    public boolean equals(Object obj):参数可以是任何对象,只有参数是一个字符串并且内容相同的才会给ture,否则返回false
    备注：任何对象都能使用Object进行接收
 */
public class Demo1String {
    public static void main(String[] args) {
        byte[] bytes={97,98,99};
        String str1=new String(bytes);
        System.out.println("字符串是:"+str1);
        String str2=null;
        String str3="VaE";
        System.out.println(str2.equalsIgnoreCase(str3)); //忽视大小写
        System.out.println("vae".equals(str2)); //推荐常亮字符串写在前面
        System.out.println(str2.equals(str2));  //不推荐写法,因为当str2=null时会产生空指针异常
    }
}

```

## 二、字符串获取的相关方法

```java
package Basis.Demo4String;
/*
     String获取相关的常用方法
     public int length获取字符串当前的字符个数,及字符串长度
     public String concat(String str)将当前字符串和参数字符串连接为返回值的字符串
     public char charArt(int index)获取指定索引位置的单个字符
     public int indexOf(String str)查找参数字符串在本字符串当中首次出现的位置，如果没有返回-1值
 */
public class Demo2String {
    public static void main(String[] args) {
        int length="dasdasdasdasdasdas".length();
        System.out.println(length);
        String str1="hs";
        String str2="-vae";
        System.out.println(str1.concat(str2)); //hs-vae
        char ch="hs-vae".charAt(1);
        System.out.println(ch);
        System.out.println("HelloWorld".indexOf("ll"));
    }
}

```

## 三、字符串截取的相关方法

```java
package Basis.Demo4String;
/*
    字符串截取的相关方法
      -public String substring(int index):截取从参数位置一致到字符串末尾,返回新字符串
      -public String substring(int begin,int end):截取从begin开始,一直到end结束中间的字符
      备注：[begin,end):包含左边,不包含右边
 */
public class Demo3String {
    public static void main(String[] args) {
        String str2="HelloWorld";
        System.out.println(str2.substring(5));     //从索引值5的位置开始截取
        System.out.println(str2.substring(5,8));   //这个截取有一个区间的[begin,end)注意是左闭右开,截取后不包含end
    }
}
```

## 四、字符串转换的相关方法

```java
package Basis.Demo4String;
/*
     String相关的转换方法
       -public char[] toCharArray():将当前字符串拆分为字符数组作为返回值
       -public byte[] getBytes():获得当前字符串底层的字节数组
       -public String replace(CharSequence oldString,CharSequence newString),
       将所有出现的老字符串替换为新的字符串,返回替换之后的结果新字符串

 */
public class Demo4String {
    public static void main(String[] args) {
        char[] array="HelloWorld".toCharArray(); //可以将字符串转换为一个个字符
        System.out.println(array[0]);
        System.out.println(array.length);

        byte[] bytes="HelloWorld".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        String lang1="闯红灯,你想死吗?";
        String lang2 = lang1.replace("死", "*"); //repalce可以进行替换字符串
        System.out.println(lang2);  //闯红灯,你想*吗?
    }
}

```

## 五、字符串分割的相关方法

```java
package Basis.Demo4String;
/*
      分割字符串的方法:
      public String[] split(String regex) 按照参数的规则,将字符串分成为若干部分
 */
public class Demo5String {
    public static void main(String[] args) {
        String str1="hs,vae";
        String[] arr=str1.split(",");  //将切割好的2份字符串放在一个字符串数组里面
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //这里有个注意的地方,如果以"."进行切分,必须写成"\\.";
        String str2="Hello.Wrold";
        String[] arr2 = str2.split("\\.");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
```

## 六、字符串练习

### 1.定义一个方法,把数组{1,2,3}按照指定格式拼接成一个字符串，格式参考:[word1#word2#word3]

```java
package Basis.Demo4String;
/*
      练习:定义一个方法,把数组{1,2,3}按照指定格式拼接成一个字符串，格式参考:[word1#word2#word3]
 */
public class Demo6String {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        printString(arr);
    }
    private static void printString(int[] arr) {
          String a="[";
        for (int i = 0; i < arr.length; i++) {
          a+="word"+arr[i]+"#";
          if(i== arr.length-1){
              a+="word"+arr[i]+"]";
              break;
          }
        }
        System.out.println(a);
    }
  }
```

### 2.键盘输入一个字符串,并且统计其中各种字符出现的次数,种类有:大写字母，小写字母，数字,其他

```java
package Basis.Demo4String;

import java.util.Scanner;

/*
      练习:键盘输入一个字符串,并且统计其中各种字符出现的次数
      种类有:大写字母，小写字母，数字,其他
 */
public class Demo7String {
    public static void main(String[] args) {
        Scanner sr=new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String input=sr.next();
        int countUpper=0;
        int countLower=0;
        int countNumber=0;
        int countAnother=0;
        char[] arr=input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch=arr[i];
            if(ch>='A'&&ch<='Z'){
              countUpper++;
            }else if(ch>='a'&&ch<='z'){
              countLower++;
            }else if(ch>='0'&&ch<='9'){
              countNumber++;
            }else{
              countAnother++;
            }
        }
        System.out.println("大写字母个数为:"+countUpper);
        System.out.println("小写字母个数为:"+countLower);
        System.out.println("数字的个数为:"+countNumber);
        System.out.println("其他的字符个数为:"+countAnother);
    }
}

```

