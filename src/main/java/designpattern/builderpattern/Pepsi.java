package designpattern.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 15:05
 * @Description:
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
