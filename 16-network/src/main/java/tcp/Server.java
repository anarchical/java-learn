package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author YeYaqiao
 */
public class Server {

    public static void main(String[] args) throws IOException {

        //建立服务端套接字，开放8080端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务端已开启");

        Socket socket;
        InputStream inputStream;
        DataInputStream dataInputStream;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;

        while (true) {
            System.out.println("服务端开启监听");
            //建立套接字接受数据
            socket = serverSocket.accept();

            //创建输入流获取数据
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String clientMsg = dataInputStream.readUTF();
            System.out.println("客户端信息：" + clientMsg);

            //创建输出流对客户端做出回复
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            String serverMsg = "服务端的信息";
            dataOutputStream.writeUTF(serverMsg);

            if (clientMsg.equals("关闭服务端"))
                break;
        }

        //释放资源
        dataOutputStream.close();
        outputStream.close();
        dataInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

        System.out.println("服务端被客户端关闭");
    }
}
