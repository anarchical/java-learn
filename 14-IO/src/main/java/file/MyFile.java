package file;

import java.io.File;
import java.io.IOException;

/**
 * @author YeYaqiao
 * 文件操作
 */
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
