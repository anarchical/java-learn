package charStream;

import java.io.*;

/**
 * @author YeYaqiao
 */
public class MyFileWriter {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";

        Writer writer = new FileWriter(path);
        writer.write("Hello World!\n你好 世界！");
        writer.flush();//清空缓冲区
        writer.close();
    }
}
