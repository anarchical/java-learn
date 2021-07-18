package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author YeYaqiao
 */
public class ClientB {
    public static void main(String[] args) throws IOException {

        //发送消息，封装消息内容
        String msg = "ClientB 的消息";
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        //发送给 127.0.0.1:9000
        DatagramPacket datagramPacket = new DatagramPacket(
                msg.getBytes(StandardCharsets.UTF_8),
                msg.getBytes(StandardCharsets.UTF_8).length,
                inetAddress,
                9000);

        //初始化发送服务并发送消息
        DatagramSocket datagramSocket = new DatagramSocket(9001);
        datagramSocket.send(datagramPacket);

        //接收消息
        byte[] bytes = new byte[1024];
        datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        String otherMsg = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("ClientB 收到的消息：" + otherMsg);

        datagramSocket.close();

    }
}
