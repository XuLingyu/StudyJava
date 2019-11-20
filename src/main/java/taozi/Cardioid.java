import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.JFrame;


public class Cardioid extends JFrame{
    private static final int WIDTH=500;
    private static final int HEIGHT=500;
    private static int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
    public Cardioid(){
        super("I love you");
        this.setBackground(Color.BLACK);
        this.setLocation((WINDOW_WIDTH-WIDTH)/2,(WINDOW_HEIGHT-HEIGHT)/2);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(getLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void paint(Graphics g){
        double x,y,r;
        Image image=this.createImage(WIDTH,HEIGHT);
        Graphics pic=image.getGraphics();
        for(int i=-2;i<90;i++){
            for(int j=-2;j<90;j++){
                r=Math.PI/45+Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
                x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+WIDTH/2;
                y=-r*Math.sin(Math.PI/45*j)+HEIGHT/3;
                pic.setColor(Color.MAGENTA);
                pic.fillOval((int)x, (int)y, 2, 2);
            }
            g.drawImage(image, 0, 0, this);
        }
    }

    public static void aaa(){
        int n = 4;
        int i, j, m;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                System.out.print("*");
            }
            for (j = 1; j <= 2 * n - 1 + (i - 6) * (i - 1); j++) {
                if (i == n)
                    break;
                System.out.print(" ");
            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                if (i == n)
                    break;
                System.out.print("*");
            }
            if (i == n) {
                for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2 - 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println("");
        } // 上面部分
        for (i = 1; i <= n - 2; i++) {
            for (j = 1; j <= 6 + (10 - n) * (n - 1) / 2 - 1 + 6 + (10 - n) * (n - 1) / 2; j++) {
                System.out.print("*");
            }
            System.out.println("");
        } // 中间部分
        m = 6 + (10 - n) * (n - 1) / 2 + 6 + (10 - n) * (n - 1) / 2 - 1;
        for (i = 1; i <= (m - 2 - 3) / 4 + 1; i++) {
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= m + 2 - 4 * i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (j = 1; j <= 2 * ((m - 2 - 3) / 4 + 1); j++)

        {
            System.out.print(" ");
        }
        System.out.print("*");// 下面部分
    }
    public static void main(String[] args) {
        aaa();


    }


}
