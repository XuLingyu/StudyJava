package designpattern.builderpattern;

/**
 * @Author:xuly
 * @Date: 2019/12/5 14:53
 * @Description: 食物条目和食物包装
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
