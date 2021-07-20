package http;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author YeYaqiao
 */
public class MyURI {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        String path = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";
        URI uri = new URI(path);
        System.out.println(uri.getHost());
        System.out.println(uri.getPort());
        System.out.println(uri.getPath());
    }
}
