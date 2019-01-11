package javamiddle.b_IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileMethods {
    /*文件练习
     * 一般来说，操作系统都在C盘，会有一个C:\WINDOWS目录，
     * 便利这个目录下的所有文件，要求包含遍历子文件夹
     * 找出这些文件里，最大的和最小（非0）的那个文件，打印出他们的文件名
     * 注意，最小的文件不能使0长度
     *
     * 思路：
     * 使用递归进行文件夹遍历。
     *
     * 可能用到的知识点有：数组的遍历，数组中元素的比较，IO的文件常用方法。
     */
    //值为2的31次方-1的常量，int类型能表示的最大值


    public static void lernFileMethods() throws IOException {
        File f = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\ReadWriteFileMethods\\file.txt");

        System.out.println("当前文件是：" +f);

        System.out.println("getAbsolutePath：" +f.getAbsolutePath());

        System.out.println("getCanonicalPath：" +f.getCanonicalPath());

        //文件是否存在
        System.out.println("判断是否存在："+f.exists());

        //是否是文件夹
        System.out.println("判断是否是文件夹："+f.isDirectory());

        //是否是文件（非文件夹）
        System.out.println("判断是否是文件："+f.isFile());

        //文件长度
        System.out.println("获取文件的长度："+f.length());

        //文件最后修改时间
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间："+d);
        //设置文件修改时间为1970.1.1 08:00:00
        f.setLastModified(0);
    }



    public static void main(String[] args) throws IOException {
        lernFileMethods();
    }
}
