package javamiddle.b_IO;

import java.io.*;

public class JavaStream {

    public static void fileOutputStreamReadFile() {
        File f = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        File f2 = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\fileoutput.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            //创建基于文件的输入输出流
            fis = new FileInputStream(f);
            fos = new FileOutputStream(f2);

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
        } finally {
            //关闭之前，要先判断该引用是否为空
            if (null != fis) {
                try {

                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (null != fos) {
                try {

                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        }
    }


    /*Split File 思路：
     *  1. 创建需要被处理的文件 以及存储目录
     *  2. 判断文件是否存在 存在的话用FileInputStream读取
     *  3. 设置大小为100*1024 Byte 的 bytr数组 设为buffer
     *  4. while 根据read（buffer）返回值-1作为循环结束条件
     *  5. FileOutputStream 写到目录下子文件
     */
    public static int splitFile() {


        File srcFile = new File("C:\\Users\\Xuan\\Desktop\\STIMEYFramework.pdf");
        String destDirectory = "E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO";
        FileInputStream input = null;
        FileOutputStream output = null;

        int fileLength = 0;
        if (!srcFile.exists()) {
            System.out.println("File dose not Exist");
            return 0;
        }
        System.out.println("File Exist: " + srcFile.getAbsoluteFile());


        try {
            input = new FileInputStream(srcFile);
            byte[] buffer = new byte[102400];
            int len = -1;

            //input.read(buffer) return -1 if read completed
            while ((len = input.read(buffer)) != -1) {
                System.out.println(len);
                File destFile = new File(destDirectory + "\\STIMEYFramework-" + fileLength);
                output = new FileOutputStream(destFile);
                output.write(buffer, 0, len);
                fileLength++;
                System.out.println("输出子文件:" + destFile.getAbsolutePath() + ",其大小是:" + destFile.length() + "字节");
            }

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != input) {
                try {

                    input.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (null != output) {
                try {

                    output.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return fileLength;
    }

    /*Merge Files 思路：
     *  1. 创建目标文件
     *  2. 用FileInputStream读取
     *  3. 设置大小为100*1024 Byte 的 bytr数组 设为buffer
     *  4. while 根据read（buffer）返回值-1作为循环结束条件
     *  5. delete 子文件
     */
    public static void mergeFiles(int fileLength) {
        File destFile = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\STIMEY.pdf");

        /*把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
        这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
        所有的流，都实现了一个接口叫做 AutoCloseable，任何类实现了这个接口，都可以在try()中进行实例化。
         并且在try, catch, finally结束的时候自动关闭，回收相关资源。*/
        try (FileOutputStream output = new FileOutputStream(destFile)) {
            int count = 0;
            while (count < fileLength) {
                File srcFile = new File(destFile.getParent(), "STIMEYFramework-" + count);
                FileInputStream input = new FileInputStream(srcFile);
                System.out.println("打开文件" + srcFile.getName());
                count++;

                byte[] buf = new byte[100 * 1024];
                int size;
                while ((size = input.read(buf, 0, buf.length)) != -1) {
                    System.out.println("读取了" + size / 1024 + "个KB");
                    output.write(buf, 0, size);
                }
                input.close();
                System.out.println(srcFile.getName() + " deleted success");
                srcFile.delete();
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        //fileOutputStreamReadFile();
        /*splitFile();*/
        mergeFiles(splitFile());
    }


}
