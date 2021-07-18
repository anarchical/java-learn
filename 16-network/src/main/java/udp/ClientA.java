package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author YeYaqiao
 */
public class ClientA {
    public static void main(String[] args) throws IOException {

        //接收消息,初始化接收功能
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        DatagramSocket datagramSocket = new DatagramSocket(9000);
        //程序会阻塞在此处等待接收数据
        datagramSocket.receive(datagramPacket);
        String otherMsg = new String(
                datagramPacket.getData(),
                0,
                datagramPacket.getLength());
        System.out.println("ClientA 收到的消息：" + otherMsg);

        //发送消息
        String msg = "ClientA 的消息";
        SocketAddress socketAddress = datagramPacket.getSocketAddress();
        datagramPacket = new DatagramPacket(
                msg.getBytes(StandardCharsets.UTF_8),
                msg.getBytes(StandardCharsets.UTF_8).length,
                socketAddress);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
