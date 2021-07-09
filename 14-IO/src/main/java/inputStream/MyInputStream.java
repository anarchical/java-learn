package inputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author YeYaqiao
 * 输入流 以字节为单位读数据
 */
public class MyInputStream {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt");
        InputStream inputStream = new FileInputStream(file);
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
