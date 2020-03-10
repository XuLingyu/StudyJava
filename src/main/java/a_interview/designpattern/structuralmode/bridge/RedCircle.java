package a_interview.designpattern.structuralmode.bridge;

/**
 * @Author:xuly
 * @Date: 2019/12/12 17:33
 * @Description:
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
