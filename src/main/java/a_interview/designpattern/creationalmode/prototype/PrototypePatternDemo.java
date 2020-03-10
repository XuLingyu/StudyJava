package a_interview.designpattern.creationalmode.prototype;

/**
 * @Author:xuly
 * @Date: 2019/12/5 16:07
 * @Description:
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape =  ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 =  ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 =  ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
