package bufferStream;

import java.io.*;

/**
 * @author YeYaqiao
 */
public class MyBufferedReader {
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
        Reader reader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }

        reader.close();
        bufferedReader.close();
    }
}
