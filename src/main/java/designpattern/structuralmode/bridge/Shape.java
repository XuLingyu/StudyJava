package designpattern.structuralmode.bridge;

/**
 * @Author:xuly
 * @Date: 2019/12/12 17:34
 * @Description:
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
