### IO流概述

IO流的主要作用是用来处理设备之间的数据传输，例如可以使用IO流将一台电脑硬盘里面的照片传输到另一台电脑上面，即将照片转换为字节，然后将字节传到另一台电脑上面，另一台电脑接收后，可以将这些字节还原为照片。

### IO流的分类

- 按照流向分类：
  - 输入流（InputStream和Reader）：从硬盘或者别的地方读到内存里面
  - 输出流（OutputStream和Writer）：从内存里面向硬盘或者别的地方输出
- 按照操作类型分类：
  - 字节流（InputStream和OutputStream） : 字节流可以操作任何数据,因为在计算机中的数据都是以字节的形式存储的。
  - 字符流（Reader和Writer） : 字符流只能操作纯字符数据，防止乱码。

#### InputStream,OutputStream,Reader和Writer都是抽象类，不能直接使用,要使用子类来继承

由一张图便于理解:

![](http://picture.hs-vae.com/IO概述图.png)



   