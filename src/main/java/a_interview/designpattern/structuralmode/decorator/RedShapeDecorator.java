package a_interview.designpattern.structuralmode.decorator;

/**
 * @Author:xuly
 * @Date: 2019/12/17 16:49
 * @Description:
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red" + decoratedShape.getClass().getName());
    }
}
