package test;

import java.io.*;

/**
 * @author YeYaqiao
 * 文件拷贝功能
 */
public class Copy {

    public static void main(String[] args) throws IOException {

        String sourceFile = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO.txt";
        String directionFile = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator + "IO_copy.txt";

        copy(sourceFile, directionFile);

    }

    public static void copy(String source, String direction) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(source);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(direction);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int asciiCode;
        while ((asciiCode = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(asciiCode);
        }

        bufferedOutputStream.flush();
        fileOutputStream.flush();

        bufferedInputStream.close();
        fileInputStream.close();

        bufferedOutputStream.close();
        fileOutputStream.close();


    }
}
