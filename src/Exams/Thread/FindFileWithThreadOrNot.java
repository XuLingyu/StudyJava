package Exams.Thread;

import java.io.*;
import java.util.Scanner;


/**
 * 假设你的项目目录是 e:/project，遍历这个目录下所有的java文件（包括子文件夹）
 * 找出文件内容包括 Magic的那些文件，并打印出来
 * <p>
 * 把 练习-查找文件内容 改为多线程查找文件内容
 * 原练习的思路是遍历所有文件，当遍历到文件是 .java的时候，查找这个文件的内容，查找完毕之后，再遍历下一个文件
 * <p>
 * 现在通过多线程调整这个思路：
 * 遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件
 */
public class FindFileWithThreadOrNot {

    public static void findFile(String key, File file) {
        //若是文件 结束
        if (file.isFile())
            return;
        //遍历路径所有文件列表
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            //if file is folder 用递归继续遍历
            if (f.isDirectory()) {
                findFile(key, f);
            }
            if (f.isFile()) {
                //判断 java文件中是否 含有 关键词 ***
                if (f.getName().endsWith(".java")) {
                    fileContainsKey(key, f);
                }
            }
        }
    }

    public static void findFileWithThread(String key, File file) {
        if (file.isFile())
            return;
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            if (f.isDirectory()) {
                findFileWithThread(key, f);
            }
            if (f.isFile()) {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        if (f.getName().endsWith(".java"))
                            fileContainsKey(key, f);
                    }
                };
                t.start();
            }
        }

    }

    private static void fileContainsKey(String key, File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                else {
                    if (line.contains(key)) {
                        System.out.println(file.getName() + "contains key");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //文件扩展名
   /* public static String getFileExtension(String fileName) {

        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null; // empty extension
        }
        return fileName.substring(lastIndexOf);
    }
    */

    public static void main(String[] args) {

        File f = new File("E:\\Stimey");
        System.out.println("输入要搜索的字符串：");
        Scanner s = new Scanner(System.in);
        String searchString = s.nextLine();
        long time1 = System.currentTimeMillis();
        findFile(searchString, f);
        long time2 = System.currentTimeMillis();
        findFileWithThread(searchString, f);
        long time3 = System.currentTimeMillis();
        System.out.println("TIME FOR FINDING ALL JAVA FILE CONTAINS *** WITHOUT THREAD: " + (time2 - time1) + "ms");
        System.out.println("TIME FOR FINDING ALL JAVA FILE CONTAINS *** WITH THREAD" + (time3 - time2) + "ms");
    }
}
