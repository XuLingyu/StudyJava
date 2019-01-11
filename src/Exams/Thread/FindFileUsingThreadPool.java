package Exams.Thread;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//在 练习-同步查找文件内容 ，如果文件特别多，就会创建很多的线程。 改写这个练习，使用线程池的方式来完成。
//
//初始化一个大小是10的线程池
//
//遍历所有文件，当遍历到文件是.java的时候，创建一个查找文件的任务，把这个任务扔进线程池去执行，继续遍历下一个文件

public class FindFileUsingThreadPool {

    public static void searchFile(File file, String key) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        if (file.isFile() && file.getName().endsWith(".java")) {
            Runnable runnable =new Runnable() {
                @Override
                public void run() {
                    fileContainsKey(key, file);
                }
            };
            //将任务加入线程池
            threadPoolExecutor.execute(runnable);
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            //因为有空指针异常 这是因为遍历C盘时候某些文件夹没有权限访问
            if (null == fileList) {
                return;
            }
            for (File f : fileList) {
                searchFile(f, key);
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
    public static void main(String[] args) {
        File file = new File("E:\\Stimey");
        long time1 = System.currentTimeMillis();
        searchFile(file, "@Service");
        long time2 = System.currentTimeMillis();
        System.out.println("TIME FOR FINDING ALL JAVA FILE CONTAINS *** WITHOUT THREADPOOL: " + (time2 - time1) + "ms");
    }

}
