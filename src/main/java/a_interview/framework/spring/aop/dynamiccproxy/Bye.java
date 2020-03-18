package a_interview.framework.spring.aop.dynamiccproxy;

/**
 * @Author:xuly
 * @Date: 2020/3/16 17:08
 * @Description:
 */
public class Bye implements ByeInterface {
    @Override
    public void sayBye() {
        System.out.println("Bye zhanghao!");
    }
}
