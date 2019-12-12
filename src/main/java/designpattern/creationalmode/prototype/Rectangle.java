package designpattern.creationalmode.prototype;

/**
 * @Author:xuly
 * @Date: 2019/12/5 16:05
 * @Description: 具体原型角色
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
