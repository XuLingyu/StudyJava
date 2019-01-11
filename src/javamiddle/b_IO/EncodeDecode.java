package javamiddle.b_IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncodeDecode {
    public static void decodeFile(File decodingFile, File decodedFile){
        try (FileReader fr = new FileReader(decodingFile); FileWriter fw = new FileWriter(decodedFile)) {
            char[] all = new char[(int)decodingFile.length()];
            char[] data;

            fr.read(all);
            System.out.println("加密前的内容是: ");
            System.out.println(all);

            data = encode(all);

            fw.write(data);
            System.out.println("加密后的内容是: ");
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //加密模块
    public static char[] encode(char[] fileContent){
        for(int i = 0; i <fileContent.length;i++){
            if( fileContent[i] <= '8' && fileContent[i] >='0')
                fileContent[i] += 1;
            if( fileContent[i] == '9')
                fileContent[i] = '0';
            if((fileContent[i] <= 'y' && fileContent[i] >='a') || (fileContent[i] <= 'Y' && fileContent[i] >='A'))
                fileContent[i] += 1;
            if( fileContent[i] == 'z')
                fileContent[i] = 'a';
            if( fileContent[i] == 'Z')
                fileContent[i] = 'A';
        }
        return fileContent;
    }

    public static void main(String[] args){
        File decodingFile = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file.txt");
        File decodedFile = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\b_IO\\file2.txt");
        decodeFile(decodingFile,decodedFile);
    }

}
