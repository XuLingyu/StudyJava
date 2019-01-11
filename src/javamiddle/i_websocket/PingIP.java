package javamiddle.i_websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingIP {
    public static void main(String[] args) throws IOException {
        //借助 Runtime.getRuntime().exec() 可以运行一个windows的exe程序

        Process p = Runtime.getRuntime().exec("ping " + "www.amazon.de");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),("GBK")));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }
}
