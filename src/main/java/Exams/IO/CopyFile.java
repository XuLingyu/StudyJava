package Exams.IO;

import java.io.*;

public class CopyFile {

    public static void copyFile(String srcFile, String destFile)
    {

        try(FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            BufferedInputStream bis = new BufferedInputStream(fis))
        {
            byte[] bytes = new byte[1024];
            int len = 0;
            while(true) {

                len=bis.read(bytes);
                if(len > 0)
                    bos.write(bytes, 0, len);
                else break;
            }
            System.out.println("复制文件成功~");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        copyFile("E:\\SSM\\StudyJava\\src\\main\\java\\Exams\\IO\\SrcFile.tex", "E:\\SSM\\StudyJava\\src\\main\\java\\Exams\\IO\\DesFile.tex");
    }
}
