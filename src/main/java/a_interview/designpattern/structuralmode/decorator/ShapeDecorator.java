package a_interview.designpattern.structuralmode.decorator;

/**
 * @Author:xuly
 * @Date: 2019/12/17 16:49
 * @Description:
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public abstract void draw();
}
