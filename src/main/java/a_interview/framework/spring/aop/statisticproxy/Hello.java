package a_interview.framework.spring.aop.statisticproxy;

/**
 * @Author:xuly
 * @Date: 2020/3/16 16:28
 * @Description:
 */
public class Hello implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }
}
