# 1. Java的简单类型及其封装器类

Java基本类型共有八种，基本类型可以分为三类，字符类型char，布尔类型boolean以及数值类型byte、short、int、long、float、double。数值类型又可以分为整数类型byte、short、int、long和浮点数类型float、double。JAVA中的数值类型不存在无符号的，它们的取值范围是固定的，不会随着机器硬件环境或者操作系统的改变而改变。实际上，JAVA中还存在另外一种基本类型void，它也有对应的包装类 java.lang.Void，不过我们无法直接对它们进行操作。8 中类型表示范围如下：

byte：8位，最大存储数据量是255，存放的数据范围是-128~127之间。

short：16位，最大数据存储量是65536，数据范围是-32768~32767之间。

int：32位，最大数据存储容量是2的32次方减1，数据范围是负的2的31次方到正的2的31次方减1。

long：64位，最大数据存储容量是2的64次方减1，数据范围为负的2的63次方到正的2的63次方减1。

float：32位，数据范围在3.4e-45~1.4e38，直接赋值时必须在数字后加上f或F。

double：64位，数据范围在4.9e-324~1.8e308，赋值时可以加d或D也可以不加。

boolean：只有true和false两个取值。

char：16位，存储Unicode码，用单引号赋值。

Java决定了每种简单类型的大小。这些大小并不随着机器结构的变化而变化。这种大小的不可更改正是Java程序具有很强移植能力的原因之一。下表列出了Java中定义的简单类型、占用二进制位数及对应的封装器类。

 

| 简单类型   | boolean | byte | char      | short | Int     | long | float | double | void |
| ---------- | ------- | ---- | --------- | ----- | ------- | ---- | ----- | ------ | ---- |
| 二进制位数 | 1       | 8    | 16        | 16    | 32      | 64   | 32    | 64     | --   |
| 封装器类   | Boolean | Byte | Character | Short | Integer | Long | Float | Double | Void |

  

对于数值类型的基本类型的取值范围，我们无需强制去记忆，因为它们的值都已经以常量的形式定义在对应的包装类中了。如：

基本类型byte 二进制位数：Byte.SIZE最小值：Byte.MIN_VALUE最大值：Byte.MAX_VALUE

基本类型short二进制位数：Short.SIZE最小值：Short.MIN_VALUE最大值：Short.MAX_VALUE

基本类型char二进制位数：Character.SIZE最小值：Character.MIN_VALUE最大值：Character.MAX_VALUE

基本类型double 二进制位数：Double.SIZE最小值：Double.MIN_VALUE最大值：Double.MAX_VALUE

注意：float、double两种类型的最小值与Float.MIN_VALUE、 Double.MIN_VALUE的值并不相同，实际上Float.MIN_VALUE和Double.MIN_VALUE分别指的是 float和double类型所能表示的最小正数。也就是说存在这样一种情况，0到±Float.MIN_VALUE之间的值float类型无法表示，0 到±Double.MIN_VALUE之间的值double类型无法表示。这并没有什么好奇怪的，因为这些范围内的数值超出了它们的精度范围。

Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少倍。比如3.14E3就是3.14×1000=3140，3.14E-3就是3.14/1000=0.00314。

Java基本类型存储在栈中，因此它们的存取速度要快于存储在堆中的对应包装类的实例对象。从Java5.0（1.5）开始，JAVA虚拟机（Java Virtual Machine）可以完成基本类型和它们对应包装类之间的自动转换。因此我们在赋值、参数传递以及数学运算的时候像使用基本类型一样使用它们的包装类，但这并不意味着你可以通过基本类型调用它们的包装类才具有的方法。另外，所有基本类型（包括void）的包装类都使用了final修饰，因此我们无法继承它们扩展新的类，也无法重写它们的任何方法。

基本类型的优势：数据存储相对简单，运算效率比较高

包装类的优势：有的容易，比如集合的元素必须是对象类型，满足了java一切皆是对象的思想

 

# 2.Java中的常量

十六进制整型常量：以十六进制表示时，需以0x或0X开头，如0xff,0X9A。

八进制整型常量：八进制必须以0开头，如0123，034。

长整型：长整型必须以L作结尾，如9L,342L。

浮点数常量：由于小数常量的默认类型是double型，所以float类型的后面一定要加f(F)。同样带小数的变量默认为double类型。

如：float f;

  f=1.3f;//必须声明f。

字符常量：字符型常量需用两个单引号括起来（注意字符串常量是用两个双引号括起来）。Java中的字符占两个字节。一些常用的转义字符：

①\r表示接受键盘输入，相当于按下了回车键；

②\n表示换行；

③\t表示制表符，相当于Table键；

④\b表示退格键，相当于Back Space键；

⑤\'表示单引号；

⑥\''表示双引号；

⑦\\表示一个斜杠\。

 

# 3. 数据类型之间的转换

## 1).简单类型数据间的转换,有两种方式:自动转换和强制转换,通常发生在表达式中或方法的参数传递时。

### 自动转换

具体地讲,当一个较"小"数据与一个较"大"的数据一起运算时,系统将自动将"小"数据转换成"大"数据,再进行运算。而在方法调用时,实际参数较"小",而被调用的方法的形式参数数据又较"大"时(若有匹配的,当然会直接调用匹配的方法),系统也将自动将"小"数据转换成"大"数据,再进行方法的调用,自然,对于多个同名的重载方法,会转换成最"接近"的"大"数据并进行调用。这些类型由"小"到"大"分别为 (byte，short，char)--int--long--float—double。这里我们所说的"大"与"小",并不是指占用字节的多少,而是指表示值的范围的大小。

①下面的语句可以在Java中直接通过：

byte b;int i=b; long l=b; float f=b; double d=b;

②如果低级类型为char型，向高级类型（整型）转换时，会转换为对应ASCII码值，例如

char c='c'; int i=c;

System.out.println("output:"+i);输出：output:99;

③对于byte,short,char三种类型而言，他们是平级的，因此不能相互自动转换，可以使用下述的强制类型转换。

short i=99 ; char c=(char)i; System.out.println("output:"+c);输出：output:c;

### 强制转换

将"大"数据转换为"小"数据时，你可以使用强制类型转换。即你必须采用下面这种语句格式： int n=(int)3.14159/2;可以想象，这种转换肯定可能会导致溢出或精度的下降。

2)表达式的数据类型自动提升, 关于类型的自动提升，注意下面的规则。

①所有的byte,short,char型的值将被提升为int型；

②如果有一个操作数是long型，计算结果是long型；

③如果有一个操作数是float型，计算结果是float型；

④如果有一个操作数是double型，计算结果是double型；

例， byte b; b=3; b=(byte)(b*3);//必须声明byte。

## 3)包装类过渡类型转换

一般情况下，我们首先声明一个变量，然后生成一个对应的包装类，就可以利用包装类的各种方法进行类型转换了。例如：

①当希望把float型转换为double型时：

float f1=100.00f;

Float F1=new Float(f1);

double d1=F1.doubleValue();//F1.doubleValue()为Float类的返回double值型的方法

②当希望把double型转换为int型时：

double d1=100.00;

Double D1=new Double(d1);

int i1=D1.intValue();

简单类型的变量转换为相应的包装类，可以利用包装类的构造函数。即：Boolean(boolean value)、Character(char value)、Integer(int value)、Long(long value)、Float(float value)、Double(double value)

而在各个包装类中，总有形为××Value()的方法，来得到其对应的简单类型数据。利用这种方法，也可以实现不同数值型变量间的转换，例如，对于一个双精度实型类，intValue()可以得到其对应的整型变量，而doubleValue()可以得到其对应的双精度实型变量。

## 4)字符串与其它类型间的转换

其它类型向字符串的转换

①调用类的串转换方法:X.toString();

②自动转换:X+"";

③使用String的方法:String.volueOf(X);

字符串作为值,向其它类型的转换

①先转换成相应的封装器实例,再调用对应的方法转换成其它类型

例如，字符中"32.1"转换double型的值的格式为:new Float("32.1").doubleValue()。也可以用:Double.valueOf("32.1").doubleValue()

②静态parseXXX方法

String s = "1";

byte b = Byte.parseByte( s );

short t = Short.parseShort( s );

int i = Integer.parseInt( s );

long l = Long.parseLong( s );

Float f = Float.parseFloat( s );

Double d = Double.parseDouble( s );

③Character的getNumericValue(char ch)方法

## 5）Date类与其它数据类型的相互转换

整型和Date类之间并不存在直接的对应关系，只是你可以使用int型为分别表示年、月、日、时、分、秒，这样就在两者之间建立了一个对应关系，在作这种转换时，你可以使用Date类构造函数的三种形式：

①Date(int year, int month, int date)：以int型表示年、月、日

②Date(int year, int month, int date, int hrs, int min)：以int型表示年、月、日、时、分

③Date(int year, int month, int date, int hrs, int min, int sec)：以int型表示年、月、日、时、分、秒

在长整型和Date类之间有一个很有趣的对应关系，就是将一个时间表示为距离格林尼治标准时间1970年1月1日0时0分0秒的毫秒数。对于这种对应关系，Date类也有其相应的构造函数：Date(long date)。

获取Date类中的年、月、日、时、分、秒以及星期你可以使用Date类的getYear()、getMonth()、getDate()、getHours()、getMinutes()、getSeconds()、getDay()方法，你也可以将其理解为将Date类转换成int。

而Date类的getTime()方法可以得到我们前面所说的一个时间对应的长整型数，与包装类一样，Date类也有一个toString()方法可以将其转换为String类。

有时我们希望得到Date的特定格式，例如20020324，我们可以使用以下方法，首先在文件开始引入，

import java.text.SimpleDateFormat;

import java.util.*;

java.util.Date date = new java.util.Date();

 

//如果希望得到YYYYMMDD的格式

SimpleDateFormat sy1=new SimpleDateFormat("yyyyMMDD");

String dateFormat=sy1.format(date);

 

//如果希望分开得到年，月，日

SimpleDateFormat sy=new SimpleDateFormat("yyyy");

SimpleDateFormat sm=new SimpleDateFormat("MM");

SimpleDateFormat sd=new SimpleDateFormat("dd");

String syear=sy.format(date);

String smon=sm.format(date);

String sday=sd.format(date);

总结：只有boolean不参与数据类型的转换

（1）.自动类型的转换：

a.常数在表数范围内是能够自动类型转换的

b.数据范围小的能够自动数据类型大的转换（注意特例）

int到float，long到float，long到double 是不会自动转换的，不然将会丢失精度

c.引用类型能够自动转换为父类的

d.基本类型和它们包装类型是能够互相转换的

（2）.强制类型转换：用圆括号括起来目标类型，置于变量前

 

# 4.Java引用类型

Java有 5种引用类型（对象类型）：类 接口 数组 枚举 标注

引用类型：底层结构和基本类型差别较大

JVM的内存空间：

（1）. Heap 堆空间：分配对象 new Student（）

（2）. Stack 栈空间：临时变量 Student stu

（3）.Code 代码区 ：类的定义，静态资源 Student.class

eg：Student stu = new Student（）； //new 在内存的堆空间创建对象

stu.study(); //把对象的地址赋给stu引用变量

上例实现步骤：a.JVM加载Student.class 到Code区

   b.new Student()在堆空间分配空间并创建一个Student实例

   c.将此实例的地址赋值给引用stu， 栈空间