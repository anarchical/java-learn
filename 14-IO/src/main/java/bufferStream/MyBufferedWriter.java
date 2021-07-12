package bufferStream;

import java.io.*;

/**
 * @author YeYaqiao
 */
public class MyBufferedWriter {
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";

        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String content = "好好学习，天天向上！字符缓冲输出流\nGood Good Study,Day Day Up!";
        bufferedWriter.write(content);

        bufferedWriter.flush();//清空缓冲区
        fileWriter.flush();//清空缓冲区

        bufferedWriter.close();
        fileWriter.close();
    }
}
