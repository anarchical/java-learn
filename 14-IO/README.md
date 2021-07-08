### IO 流

输入：将文件以数据流的形式读取到程序中

输出：将程序中的数据以数据流的形式写入到外部文件中或下载

#### File 类

java.io.File 类用来创建文件对象

```java
public class MyFile {
    public static void main(String[] args) throws IOException {

        File file=new File(System.getProperty("user.dir")+"\\14-IO\\IO.txt");
        if(file.exists()){
            System.out.println(file+"已存在");
            System.out.println("文件名："+file.getName());
            System.out.println("文件长度："+file.length());
            System.out.println("文件路径："+ file.getPath());
            System.out.println("文件所在目录："+file.getParent());
            if(file.getParentFile().isDirectory()){
                System.out.println("上层文件是一个文件夹");
            }
            System.out.println("文件名："+file.getName());
        }else {
            
           if (file.createNewFile()){
               System.out.println("创建成功");
           }
        }
    }
}
```

#### 字节流

1. 按照方向分：输入流、输出流
2. 按照单位分：字节流和字符流
3. 按照功能分：节点流和处理流

常用的有输入字节流（InputStream）和输出字节流（OutputStream）

##### InputStream（抽象类）

常用实现类

##### OutputStream（抽象类）

常用实现类

#### 常见问题

1. 获取当前工程路径有哪些方法？

   `System.getProperty("user.dir")`

   `File file= new File(""); file.getCanonicalPath()`