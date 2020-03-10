package a_interview.designpattern.creationalmode.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 15:04
 * @Description:
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
