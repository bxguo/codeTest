package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by 郭炳侠 on 2020/9/27.
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;
    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
        byte[] bytes = new byte[50];
        while (true) {
            try {
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                in.read(bytes);
                System.out.println(server.getRemoteSocketAddress() + ": " + new String(bytes).trim());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                String resp = server.getLocalSocketAddress() + ": 谢谢连接我，Goodbye!";
                out.write(resp.getBytes("utf-8"));
                System.out.println("消息：'" + resp + "' 已发送");
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {

        try {
            Thread t = new GreetingServer(9999);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
