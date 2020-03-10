package a_interview.designpattern.creationalmode.prototype;

/**
 * @Author:xuly
 * @Date: 2019/12/5 16:06
 * @Description: 具体原型角色
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
