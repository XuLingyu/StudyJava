package javamiddle.b_IO;

import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.io.*;

/*对象流指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘
    一个对象以流的形式进行传输，叫做序列化。 该对象所对应的类，必须是实现Serializable接口*/
public class ObjectInputOutputStream {
    public static void main(String[] args) {
        //创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
        Hero h = new Hero();
        h.name = "garen";
        h.hp = 616;

        //准备一个文件用于保存该对象
        File f =new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\garen.lol");

        try(
                ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(f));
                ObjectInputStream ois =new ObjectInputStream(new FileInputStream(f))
        ) {
            oos.writeObject(h);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
