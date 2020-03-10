package a_interview.designpattern.creationalmode.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 15:04
 * @Description:
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
