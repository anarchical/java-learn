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

        System.out.println("可能阻塞获取的资源大小："+inputStream.available());
        System.out.println("实际资源的大小"+url.openConnection().getContentLength());

        int asciiCode;
        while ((asciiCode = inputStream.read()) != -1) {
            outputStream.write(asciiCode);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
