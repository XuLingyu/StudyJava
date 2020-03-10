package a_interview.designpattern.structuralmode.bridge;

/**
 * @Author:xuly
 * @Date: 2019/12/12 17:35
 * @Description:
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
