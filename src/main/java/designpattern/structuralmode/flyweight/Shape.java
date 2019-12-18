package designpattern.structuralmode.flyweight;

/**
 * @Author:xuly
 * @Date: 2019/12/18 11:18
 * @Description:
 */
public interface Shape {
    void draw();
}
class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color){
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }

    @Override
    public String toString() {
        return "Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius;
    }
}
