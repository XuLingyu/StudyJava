package javamiddle.b_IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadFromConsole {

    public static void systemIn(){
        try (InputStream is = System.in) {
            boolean stop = true;
            while (stop) {
                // 敲入a,然后敲回车可以看到
                // 97 13 10
                // 97是a的ASCII码
                // 13 10分别对应回车换行
                char i = (char) is.read();
                System.out.println(i);
                if(i == 'q'){
                    stop = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sanner(){
        Scanner s = new Scanner(System.in);
        while(true){
            String line = s.nextLine();
            System.out.println(line);
            if(line.equals("q"))
                break;
        }
    }

    public static void main(String[] args) {
        //systemIn();
        sanner();

    }

}


