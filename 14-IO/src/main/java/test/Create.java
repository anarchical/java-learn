package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author YeYaqiao
 */
public class Create {
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "14-IO" + File.separator;

        Scanner scanner = new Scanner(System.in);
        String fileName;
        String fileContent;

        System.out.println("请输入文件名称：");
        fileName = scanner.next();

        System.out.println("请输入文件内容：");
        fileContent = scanner.next();

        File file = new File(path.concat(fileName));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(fileContent.getBytes(StandardCharsets.UTF_8));

        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
