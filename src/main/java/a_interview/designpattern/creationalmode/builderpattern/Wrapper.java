package a_interview.designpattern.creationalmode.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 14:55
 * @Description: 实现 Packing 接口的实体类
 */
public class Wrapper implements  Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
