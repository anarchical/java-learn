### IO 流

输入：将文件以数据流的形式读取到程序中

输出：将程序中的数据以数据流的形式写入到外部文件中或下载

流的概念：

1. 按照方向分：输入流 和 输出流 （Input、Output）
2. 按照单位分：字节流 和 字符流
3. 按照功能分：节点流（FileInputStream）和 处理流（BufferedInputStream）

#### File 类

* java.io.File 类用来创建文件对象

  ```java
  public class MyFile {
      public static void main(String[] args) throws IOException {
  
          String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
          File file = new File(path);
  
          if (file.exists()) {
  
              System.out.println(file + "已存在");
              System.out.println("文件名：" + file.getName());
              System.out.println("文件大小，单位为字节：" + file.length());
              System.out.println("文件路径：" + file.getPath());
              System.out.println("文件所在目录：" + file.getParent());
              if (file.getParentFile().isDirectory()) {
                  System.out.println("上层文件是一个文件夹");
              }
              System.out.println("文件名：" + file.getName());
          } else {
  
              if (file.createNewFile()) {
                  System.out.println("创建成功");
              }
          }
      }
  }
  ```

* 常用方法

  | 方法名 |      |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |

  

#### 字节流

以字节（byte）为单位读取数据，常用的有输入字节流（InputStream）和输出字节流（OutputStream）

##### InputStream（抽象类）

* 常用实现类 FileInputStream，以**字节**为单位读数据

  ```java
  public class MyInputStream {
      public static void main(String[] args) throws IOException {
          String path=System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
          InputStream inputStream = new FileInputStream(path);
          //字节流里面还未被读取的数据
          System.out.println(inputStream.available());
          //默认 read() 方法读取字符的 ASCII，以字节为单位读取
          int ascii = inputStream.read();
          while (ascii != -1) {
              System.out.println(ascii);
              ascii = inputStream.read();
          }
          inputStream.close();
      }
  }
  ```

* 常用方法

  | 方法名 | 作用 |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |

  

##### OutputStream（抽象类）

* 常用实现类 FileOutputStream，以**字节**为单位写数据

  ```java
  public class MyOutputStream {
  
      public static void main(String[] args) throws IOException {
          String path=System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
          OutputStream outputStream= new FileOutputStream(path);
          //ASCII 码写到文件中变成字符 72是 H 的 ASCII code
          outputStream.write(72);
          outputStream.close();
      }
  }
  ```

* 常用方法

  | 方法名 | 作用 |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |
  

#### 字符流

以字符（char）为单位读取数据，常用的有输入字符流（Reader）和输出字符流（Writer）

##### Reader（抽象类）

* 常用实现类 FileReader，以**字符**为单位读数据

  ```java
  public class MyFileReader {
  
      public static void main(String[] args) throws IOException {
  
          String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
  
          Reader reader = new FileReader(path);
  
          int asciiCode = reader.read();
  
          while (asciiCode != -1) {
              System.out.println(asciiCode);
              System.out.println(Character.toChars(asciiCode));
              asciiCode = reader.read();
          }
        reader.close();
      }
  }
  ```

  FileReader 的 read() 方法与 FileInputStream 的 read() 方法相同，默认读取出来的都是 ascii 码

* 常用方法

  | 方法名 | 作用 |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |


##### Writer（抽象类）

* 常用实现类 FileOutputStream，以**字符**为单位写数据

  ```java
  public class MyOutputStream {
  
      public static void main(String[] args) throws IOException {
          File file = new File(System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt");
          OutputStream outputStream= new FileOutputStream(file);
          outputStream.write("Hello World!\n你好 世界！");
          outputStream.close();
      }
  }
  ```

* 常用方法

  | 方法名 | 作用 |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |

#### 缓冲流

缓冲流属于处理流（无法直接操作文件），必须基于节点流

分为 字节输入输出缓冲流、字符输入输出缓冲流

##### 字节缓冲流

* 字节缓冲输入流 BufferedInputStream
* 字节缓冲输出流 BufferedOutputStream

##### 字符缓冲流

* 字符缓冲输入流 BufferedReader

  ```java
  public class MyBufferedReader {
      public static void main(String[] args) throws IOException {
  
          String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
          Reader reader = new FileReader(path);
  
          BufferedReader bufferedReader = new BufferedReader(reader);
  
          String line = bufferedReader.readLine();
          while (line != null) {
              System.out.println(line);
              line = bufferedReader.readLine();
          }
  
          reader.close();
          bufferedReader.close();
      }
  }
  ```

  常用方法

  | 方法名 | 作用 |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |

* 字符缓冲输出流

  ```java
  
  ```

  常用方法

  | 方法名 | 作用 |
  | ------ | ---- |
  |        |      |
  |        |      |
  |        |      |



#### 常见问题

1. 获取当前工程路径有哪些方法？

   `System.getProperty("user.dir")`

   `File file= new File(""); file.getCanonicalPath()`
   
2. File.separator 的作用是什么？

   为了屏蔽文件分隔符在不同系统上的差异

   Windows 的文件分隔符为 / 或者 \

   Linux 的文件分隔符为 /

   Unix 的文件分隔符为 /

3. 为什么有些字符所占的空间都不一样呢？

   在不同的文件编码下，不同的字符类型所占的空间都是不一样的

   如：UTF-8 一个英文字符占1字节，一个中文字符占3字节
   
4. 字节流与字符流的区别？

   字节流以字节为单位读取数据，字符流以字符为单位