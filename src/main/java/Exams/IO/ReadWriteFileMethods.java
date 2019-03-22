package Exams.IO;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFileMethods {

    public static void scannerReadFile() {
        List<String[]> data = new ArrayList<>();
        File f = new File("E:\\SSM\\StudyJava\\src\\main\\java\\javamiddle\\b_IO\\file.txt");
        try (Scanner myReader = new Scanner(f)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] lineArray = line.split(" ");
                data.add(lineArray);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String[] str : data) {
            /*for (String s : str) {
                System.out.print(s + " ");
            }*/

            System.out.println(Arrays.asList(str));
        }
    }

    //使用字符流读写文件
    public static void fileReadIO() {
        File input = new File("E:\\SSM\\StudyJava\\src\\main\\java\\javamiddle\\b_IO\\file.txt");
        File output = new File("E:\\SSM\\StudyJava\\src\\main\\java\\javamiddle\\b_IO\\fileoutput.txt");

        // 创建基于文件的Reader
        try (FileReader fr = new FileReader(input); FileWriter fw = new FileWriter(output)) {
            char[] all = new char[(int) input.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b : all) {
                // 打印出来是A B
                System.out.print(b);
            }
            fw.write(all);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void outputStreamReadFile() {
        File f = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        File f2 = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\fileoutput.txt");
        try (FileInputStream fis = new FileInputStream(f); FileOutputStream fos = new FileOutputStream(f2)){
            //创建字节数组，其长度就是文件的长度
            byte[] all = new byte[(int) f.length()];
            //以字节流的形式读取文件所有内容

            // 把数据写入到输出流
            fis.read(all);

            for (byte b : all) {
                System.out.print(b + " ");
            }
            fos.write(all, 0, (int) f.length());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //Read File with buffer
    public static void bufferRead(){
        List<String[]> data = new ArrayList<>();
        File f = new File("E:\\SSM\\StudyJava\\src\\main\\java\\javamiddle\\b_IO\\file.txt");
        try(BufferedReader bf = new BufferedReader(new FileReader(f))){
           while(true){
               String line = bf.readLine();
               if(line != null){
                   String[] strs = line.split(" ");
                   data.add(strs);
               }
               else break;

           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.forEach(s -> System.out.println(Arrays.asList(s)));

    }


    public static void main(String[] args) throws IOException {

        //scannerReadFile();
        //fileReadIO();
        bufferRead();
    }
}