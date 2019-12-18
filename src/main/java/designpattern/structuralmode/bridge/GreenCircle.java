package designpattern.structuralmode.bridge;

/**
 * @Author:xuly
 * @Date: 2019/12/12 17:34
 * @Description:
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
