### 网络编程

#### 计算机网络

计算机网络就是通过硬件设施、传输媒介把各个不同物理地址上的计算机连接起来，形成一个资源共享和数据传输的网络系统

不同的终端设备通过网络进行连接交互的时候，需要遵守一定的规则，这个规则就是网络协议；有三个要素

* 语法：数据信息的结构
* 语义：描述动作和响应
* 同步：动作的实现顺序

##### 网络层次划分（解耦合）

为了使不同计算机厂家生产的计算机能够相互通信，以便在更大的范围内建立计算机网络，国际标准化组织（ISO）在1978年提出了"开放系统互联参考模型"，即著名的OSI/RM模型（Open System Interconnection/Reference Model）。它将计算机网络体系结构的通信协议划分为七层，自下而上依次为：物理层（Physics Layer）、数据链路层（Data Link Layer）、网络层（Network Layer）、传输层（Transport Layer）、会话层（Session Layer）、表示层（Presentation Layer）、应用层（Application Layer）。其中第四层完成数据传送服务，上面三层面向用户。

除了标准的OSI七层模型以外，常见的网络层次划分还有TCP/IP四层协议以及TCP/IP五层协议，它们之间的对应关系如下图所示：

<table>
  <tr>
    <td><b>OSI 七层模型</b></td>
    <td><b>TCP/IP 五层模型</b></td>
    <td><b>TCP/IP 四层模型</b></td>
    <td><b>对应网络协议</b></td>
    <td><b>基本功能</b></td>
 </tr>
  <tr>
    <td>应用层</td>
    <td rowspan='3'>应用层</td>
    <td rowspan='3'>应用层</td>
    <td>HTTP、FTP、SSH、NFS、SMTP、WAIS</td>
    <td>为用户提供具体的应用服务</td>
  </tr>
  <tr>
    <td>表示层</td>
    <td>Telnet、Rlogin、SNMP、Gopher</td>
    <td>数据的表达以及数据格式的转换</td>
  </tr>
  <tr>
    <td>会话层</td>
    <td>DNS、SMTP</td>
    <td>会话的控制</td>
  </tr>
  <tr>
    <td>传输层</td>
    <td>传输层</td>
    <td>传输层</td>
    <td>TCP、UDP</td>
    <td>保证端到端的传输</td>
  </tr>
  <tr>
    <td>网络层</td>
    <td>网络层</td>
    <td>网络层</td>
    <td>IP、ICMP、ARP、RARP、AKP、UUCP</td>
    <td>负责网间两点的可达性，路由寻址</td>
  </tr>
  <tr>
    <td>数据链路层</td>
    <td>数据链路层</td>
    <td rowspan='2'>网络接口层</td>
    <td>FDDI、Ethernet、Arpanet、PDN、SLIP、PPP</td>
    <td>负责网络内部帧的传输</td>
  </tr>
  <tr>
    <td>物理层</td>
    <td>物理层</td>
    <td>IEEE802.1A、IEEE802.2~IEEE802.11</td>
    <td>负责链路上比特流的传输</td>
  </tr>
</table>

##### TCP/IP 协议

TCP/IP协议是一个网络通信模型（OSI 七层模型、TCP/IP 五次模型、TCP/IP 四层），以及一整个网络传输协议家族，为互联网的基础通信架构

###### IP（Internet Protocol）

网际互连协议

* 在网络层，负责网间的路由寻址，用来确定终端的位置

###### TCP（Transmisson Control Protocol）

传输控制协议

* 在传输控制层，面向连接的、可靠的传输协议
* 连接只能有两个端点（一对一，文件传输、收发邮件、远程登录）
* 提供全双工通信；允许双方在任何时候都能发送数据；设有发送和接收缓存，临时存放双方的通信数据
* 面向字节流，将应用层交下来的数据看成一连串的无结构字节序列
* 首部开销大，有20字节

###### UDP（User Datagram Protocol）

用户数据报协议

* 在传输控制层，提供无连接的数据传输服务（不保证数据传输的可靠性）
* 是面向报文的
* 没有拥塞控制，不会出现网络拥塞使主机的发送速率降低，适合对实时需求高的应用（直播、视频会议）
* 支持一对一、一对多、多对多、多对一的交互通信
* 首部开销小，只有8字节

##### TCP 的连接建立和断开

基础术语

| 缩写 | 全称            | 含义                         |
| ---- | --------------- | ---------------------------- |
| URG  | urgent          | 紧急                         |
| ACK  | acknowledgment  | 确认（确认收到SYN或FIN请求） |
| PSH  | push            | 推送                         |
| RST  | reset           | 复位                         |
| SYN  | synchronization | 同步（请求建立连接）         |
| FIN  | finish          | 终止（终止连接）             |
| seq  | sequence        | 序列（数据的序列号）         |

###### 建立连接（三次握手）

```sequence
客户端 -> 服务端: SYN=1 seq=x
服务端 -> 客户端: SYN=1 ACK=1 ack=x+1 seq=y
客户端 -> 服务端: ACK=1 ack=y+1 seq=x+1
```

三次握手

0. TCP 服务器会首先创建传输控制模块 TCB ，时服务器进入 LISTEN 监听状态，时刻准备接收连接请求

1. 客户端发送带有 请求建立连接 SYN=1 和 初始序号 seq=x 的数据包给服务端，请求建立连接（此时客户端什么都不能确认，服务端可以确认对方发送正常，自己接收正常）
2. 服务端收到数据后，发送带有 SYN=1，确认建立连接 ACK=1 ，确认序号 ack=x+1，初始序号 seq=y 的数据包给客户端，确认并请求建立连接（客户端可以确认自己发送、接受正常，对方发送、接受正常；服务端可以确认对方发送正常，自己接收正常）
3. 客户端收到数据后，发送带有 ACK=1，确认序号 ack=y+1，自己的序号 seq=x+1 的数据包给服务端，确认连接建立（客户端可以确认自己发送、接受正常，对方发送、接受正常；服务端可以确认对方发送、接收正常，自己发送、接收正常）

三次握手可以保证客户端和服务端都能够确认自己收发和对方收发数据正常

###### 结束连接（四次挥手）

数据传输结束后，双方都可以主动发起结束连接的请求，这里假设客户端先发起结束请求

```sequence
客户端 -> 服务端: FIN=1 seq=u
服务端 -> 客户端: ACK=1 ack=u+1 seq=v
服务端 --> 客户端: 服务端可以继续向客户端传输数据
服务端 -> 客户端: FIN=1 ACK=1 seq=w ack=u+1
客户端 -> 服务端: ACK=1 ack=w+1 seq=u+1
```


四次挥手

1. 客户端请求关闭连接，发送 FIN=1，seq=u（u等于上一个报文的序号+1） 的数据包给服务端，并停止向服务端发送数据，但是还可接收数据
2. 服务端收到关闭请求，发出 ACK=1，ack=u+1，seq=v 的数据包给客户端，此时服务端停止接收客户端的数据，但是还可以向客户端发送数据，直到剩余数据发送完成
3. 剩余数据发送完毕后，服务端发出 FIN=1，ACK=1，ack=u+1，seq=w 的数据包给客户端，等待客户端确认
4. 客户端收到确认关闭的 FIN 内容后，发出 ACK=1，ack=w+1，seq=u+1 的数据包给服务端，确认关闭客户端的连接状态；服务端收到后直接关闭连接，并释放相关资源

#### Java 网络编程

也叫Socket 编程；所谓套接字，就是对网络中不同主机上的应用进程之间进行双向通信的端点的抽象。

##### URI



##### URL

##### TCP

Java 实现 TCP 协议，通过 Socket 完成 TCP 程序的开发

* server 端

  ```java
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
  ```

* client 端

  ```java
  public class Client {
  
      public static void main(String[] args) throws IOException {
  
          //创建套接字指定要连接的 ip 和端口
          Socket socket = new Socket("127.0.0.1", 8080);
          System.out.println("客户请求连接");
  
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
  ```

##### UDP



#### 常见问题

1. 为什么需要三次握手四次挥手？

   三次握手：

   为了建立面向连接的可靠通信（**客户端和服务端都要确认自己收发和对方收发数据正常**）

   1. 第一次握手：此时客户端什么都不能确认，服务端收到消息可以确认对方发送正常，自己接收正常
   2. 第二次握手：客户端可以确认自己发送、接受正常，对方发送、接受正常；服务端可以确认对方发送正常，自己接收正常
   3. 第三次握手：客户端可以确认自己发送、接受正常，对方发送、接受正常；服务端可以确认对方发送、接收正常，自己发送、接收正常

   四次挥手：

   为了防止数据未传输完成就关闭连接

   假如先收到 FIN 的一端数据还没有传输完成，此时并不能直接关闭连接，只能先回复 ACK=1 确认收到数据，直到数据传输完成以后，再回复 FIN=1，发起关闭连接请求，等待对方回复 ACK=1 后双方都关闭连接

2. 为什么不不用两次握手呢？

   两次握手存在的问题：

   假设有这样一种场景，客户端发送了第一个请求连接并且没有丢失，只是因为在网络结点中滞留的时间太长了，由于TCP的客户端迟迟没有收到确认报文，以为服务器没有收到，此时重新向服务器发送这条报文，此后客户端和服务器经过两次握手完成连接，传输数据，然后关闭连接。此时此前滞留的那一次请求连接，网络通畅了到达了服务器，这个报文本该是失效的，但是，两次握手的机制将会让客户端和服务器再次建立连接，这将导致不必要的错误和资源的浪费。

3. 为什么最后一次挥手完成后，还有等待 2MSL 才关闭连接？

   2MSL 默认为 4 分钟，可以设置修改

   1. 若客户端最后一次发送完 ACK ，服务端由于网络原因没有收到，则服务端会重新发送 FIN，直到收到客户端发送的 ACK；但是若客户端最后一次发送完 ACK 后直接关闭，服务端由于网络原因没有收到，服务端就会一直重复发送 FIN 给客户端，造成服务端连接关闭失败
   2. 客户端延时关闭可以大概率保证网络中所有相关的报文都消失，一定程度上防止已经失效的报文出现在新的连接中