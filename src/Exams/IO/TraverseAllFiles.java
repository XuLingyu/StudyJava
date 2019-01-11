package Exams.IO;

import java.io.File;

public class TraverseAllFiles {
    static int countFile= 0;
    static int subfolder =0;
    static long minSize = Integer.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;

    //使用递归来遍历一个文件夹的子文件
    public static void listFiles(File file){
        //先判断是文件还是文件夹，是文件把他们用listFile输出为文件数组
        if(file.isFile()){
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0 && file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }
            countFile++;
        }

        if(file.isDirectory()){
            File[] fs = file.listFiles();
            //因为有空指针异常 这是因为遍历C盘时候某些文件夹没有权限访问
            if (null==fs) {
                return;
            }
            for (File f : fs) {
                listFiles(f);
            }
            subfolder++;
        }
    }
    public static void main(String[] args){
        File f = new File("E:\\SSM");
        listFiles(f);
        System.out.println("文件数目为："+countFile+"个");
        System.out.println("子文件夹数目为："+subfolder+"个");
        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());

    }

}
