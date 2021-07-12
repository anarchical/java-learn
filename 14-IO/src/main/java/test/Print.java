package test;

import java.io.*;

/**
 * @author YeYaqiao
 */
public class Print {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";

        File file = new File(path);
        Reader reader = new FileReader(file);

        int asciiCode;
        while ((asciiCode = reader.read()) != -1) {
            System.out.print(Character.toChars(asciiCode));
        }
    }
}
