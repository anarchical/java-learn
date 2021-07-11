package charStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author YeYaqiao
 */
public class MyFileReader {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";

        Reader reader = new FileReader(path);

        int asciiCode = reader.read();

        while (asciiCode != -1) {
            System.out.println(asciiCode);
            System.out.println(Character.toChars(asciiCode));
            asciiCode = reader.read();
        }

        reader.close();
    }
}
