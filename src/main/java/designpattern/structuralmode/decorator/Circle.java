package designpattern.structuralmode.decorator;

/**
 * @Author:xuly
 * @Date: 2019/12/17 16:48
 * @Description:
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
