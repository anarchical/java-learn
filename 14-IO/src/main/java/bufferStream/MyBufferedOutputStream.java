package bufferStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author YeYaqiao
 */
public class MyBufferedOutputStream {
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";

        OutputStream outputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        String content = "好好学习，天天向上！字节缓冲输出流\nGood Good Study,Day Day Up!";
        bufferedOutputStream.write(content.getBytes(StandardCharsets.UTF_8));//写入数据

        bufferedOutputStream.flush();
        outputStream.flush();

        bufferedOutputStream.close();//关闭缓冲输出字节流
        outputStream.close();//关闭输出字节流
    }
}
