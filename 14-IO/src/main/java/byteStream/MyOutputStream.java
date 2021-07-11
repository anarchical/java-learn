package byteStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author YeYaqiao
 * 输出流 以字节为单位写数据
 * 英文字符占1字节，中文字符占3字节
 */
public class MyOutputStream {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
        OutputStream outputStream = new FileOutputStream(path);

        byte[] bytes = new byte[]{72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100};
        //ASCII 码写到文件中变成字符 72是 H 的 ASCII code
        outputStream.write(bytes);
        outputStream.close();
    }
}
