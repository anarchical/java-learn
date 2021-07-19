package http;

import java.io.*;
import java.net.URL;

/**
 * @author YeYaqiao
 */
public class MyURL {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + File.separator + "16-network" + File.separator + "baidu.png";
        String baiDuImage = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";

        URL url = new URL(baiDuImage);
        InputStream inputStream = url.openStream();
        OutputStream outputStream = new FileOutputStream(path);

        System.out.println(inputStream.available());
        int temp;
        if ((temp = inputStream.read()) != -1) {
            outputStream.write(temp);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();

    }
}
