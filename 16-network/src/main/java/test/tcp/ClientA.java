package test.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author YeYaqiao
 */
public class ClientA {

    public static void main(String[] args) throws IOException {
        //创建套接字指定要连接的 ip 和端口
        Socket socket = new Socket("127.0.0.1", 8080);

        //创建输出流对服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String clientMsg = "关闭服务端";
        dataOutputStream.writeUTF(clientMsg);

        //创建输入流就收返回数据
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String serverMsg = dataInputStream.readUTF();
        System.out.println("服务端信息：" + serverMsg);

        //释放资源
        dataInputStream.close();
        inputStream.close();
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
