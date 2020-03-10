package a_interview.designpattern.creationalmode.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 15:04
 * @Description:
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
