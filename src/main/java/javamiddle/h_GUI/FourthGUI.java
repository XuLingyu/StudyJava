package javamiddle.h_GUI;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//JFrame > JPanel > Component(Button checkbox menu and so on)

//助TabbedPanel显示一个包下所有的java文件
//假设包 jdbc 中有如下java文件
public class FourthGUI {
    public static void main(String[] args) {

        final JFrame f = new JFrame("显示文件夹下的内容");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JTabbedPane tp = new JTabbedPane();
        f.setContentPane(tp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        File file = new File("E:\\SSM\\StudyJava\\src\\javamiddle\\h_GUI");
        File[] listFiles = file.listFiles();
        for(int i=0;i<listFiles.length;i++){

            final JPanel p1 = new JPanel();
            DefaultEditorKit kit = new DefaultEditorKit();
            final JTextArea textarea = new JTextArea(25, 80);
            try {
                FileReader in = new FileReader(listFiles[i]);
                textarea.setText("");
                kit.read(in,textarea.getDocument(),0);
            } catch (IOException | BadLocationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            textarea.setLineWrap(true);
            textarea.setWrapStyleWord(true);
            p1.add(textarea);
            tp.add(listFiles[i].getName(), p1);
        }
    }
}
