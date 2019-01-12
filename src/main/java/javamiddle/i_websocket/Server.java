package javamiddle.i_websocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//练习-服务端和客户端互聊 中，只能一人说一句，说了之后，必须等待另一个人的回复，才能说下一句。
public class Server {


    public static void main(String[] args)  {
        try {
            //服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);
            //在8888端口上监听，看是否有连接请求过来监听并接受socket连接，方法一直阻塞，直到有连接
            Socket s =  ss.accept();

            //启动发送消息线程
            new SendThread(s).start();
            //启动接受消息线程
            new RecieveThread(s).start();

           /* InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            Scanner sc = new Scanner(System.in);

            while (true) {
                String serverAcceptMsg = dis.readUTF();
                if(serverAcceptMsg!= null)
                    System.out.println("收到客户端信息"+serverAcceptMsg);

                String serverSenderMsg = sc.nextLine();
                if(serverSenderMsg!= null)
                    dos.writeUTF(serverSenderMsg);
            }*/

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
