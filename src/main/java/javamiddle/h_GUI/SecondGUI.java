package javamiddle.h_GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//java的图形界面中，容器是用来存放 按钮，输入框等组件的。
//
//窗体型容器有两个，一个是JFrame,一个是JDialog

public class SecondGUI {
    public static void main(String[] args) {
        //JFrame是最常用的窗体型容器，默认情况下，在右上角有最大化最小化按钮
        final JFrame f = new JFrame("外部窗体");
        f.setSize(500, 300);
        f.setLocation(100, 100);
        f.setLayout(null);

        //JDialog也是窗体型容器，右上角没有最大和最小化按钮
        final JDialog d = new JDialog(f);
        d.setSize(400, 300);
        d.setLocation(150, 150);
        d.setModal(true);
        d.setLayout(null);


        final JButton b1 = new JButton("打开一个模态窗口");
        b1.setBounds(50, 50, 280, 30);
        b1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(!d.isVisible())
                    d.setVisible(true);
                d.setVisible(true);
            }
        });
        final JButton b2 = new JButton("锁定大小");
        b2.setBounds(50, 50, 280, 30);
        b2.addMouseListener(new MouseAdapter() {
            //设置可调整大小
            public void mouseClicked(MouseEvent e) {
                if (d.isResizable())
                    d.setResizable(false);
                else
                    d.setResizable(true);
            }
        });
        f.add(b1);
        d.add(b2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
