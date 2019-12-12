package designpattern.creationalmode.prototype;

/**
 * @Author:xuly
 * @Date: 2019/12/5 16:06
 * @Description: 具体原型角色
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
