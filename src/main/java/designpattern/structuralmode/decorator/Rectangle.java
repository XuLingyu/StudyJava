package designpattern.structuralmode.decorator;

/**
 * @Author:xuly
 * @Date: 2019/12/17 16:48
 * @Description:
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
