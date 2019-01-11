package javamiddle.b_IO;

import java.io.*;


/*使用数据流的writeUTF()和readUTF() 可以进行数据的格式化顺序读写
    如本例，通过DataOutputStream 向文件顺序写出 布尔值，整数和字符串。
    然后再通过DataInputStream 顺序读入这些数据。

    注： 要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，
    否则会出现EOFException，因为DataOutputStream 在写出的时候会做一些特殊标记，
    只有DataInputStream 才能成功的读取。*/
public class DataInputOutputStream {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        File f =new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        try (
                //要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的
                DataInputStream dis =new DataInputStream(new FileInputStream(f))
        ){
            boolean b= dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();
            long l = dis.readLong();

            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);
            System.out.println("读取到long:"+l);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write() {
        File f =new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        try (
                DataOutputStream dos =new DataOutputStream(new FileOutputStream(f))
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
            dos.writeLong(1235445);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
