package a_interview.designpattern.creationalmode.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 15:04
 * @Description:
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
