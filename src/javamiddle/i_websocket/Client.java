package javamiddle.i_websocket;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args)  {

        try {
            //连接到本机的8888端口
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);


            // 启动发送消息线程
            new SendThread(s).start();
            // 启动接受消息线程
            new RecieveThread(s).start();

            //直接使用字节流收发字符串比较麻烦，使用数据流对字节流进行封装，这样收发字符串就容易了
            // 打开输出流 把输出流封装在DataOutputStream中
            /*OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            InputStream is = s.getInputStream();           //输入流  可读取字节
            DataInputStream dis = new DataInputStream(is);  //输入流  可读取字符串

            Scanner sc = new Scanner(System.in);

            while(true) {

                String clientSenderMsg = sc.nextLine();
                if(clientSenderMsg != null)
                    dos.writeUTF(clientSenderMsg);

                String clientAcceptMsg = dis.readUTF();
                if(clientAcceptMsg != null)
                    System.out.println("收到服务端信息" + clientAcceptMsg);
            }
*/
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}