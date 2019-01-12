package javamiddle.b_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFileMethods {

    public static void scannerReadFile() {
        List<String[]> data = new ArrayList<>();
        File f = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        System.out.println(Arrays.asList(f.getParentFile().list()));
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
        File input = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        File output = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\fileoutput.txt");

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

    public static void main(String[] args) throws IOException {

        scannerReadFile();
        fileReadIO();
    }
}