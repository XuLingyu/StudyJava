package a_interview.designpattern.creationalmode.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 15:03
 * @Description:  Item 接口的抽象类
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
