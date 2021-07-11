package bufferStream;

import java.io.*;

/**
 * @author YeYaqiao
 */
public class MyBufferedInputStream {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
        InputStream inputStream = new FileInputStream(path);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int asciiCode = bufferedInputStream.read();
        while (asciiCode != -1) {
            System.out.println(asciiCode);
            asciiCode = bufferedInputStream.read();
        }


        inputStream.close();
        bufferedInputStream.close();
    }
}
