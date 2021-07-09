package outputStream;

import java.io.*;

/**
 * @author YeYaqiao
 * 输出流 以字节为单位写数据
 */
public class MyOutputStream {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt");
        OutputStream outputStream= new FileOutputStream(file);
        //ASCII 码写到文件中变成字符
        outputStream.write(72);
        outputStream.close();
    }
}
