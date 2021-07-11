package bufferStream;

import java.io.*;

/**
 * @author YeYaqiao
 */
public class MyBufferedOutputStream {
    public static void main(String[] args) throws FileNotFoundException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
        OutputStream outputStream = new FileOutputStream(path);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

    }
}
