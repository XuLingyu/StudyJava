package a_interview.framework.spring.aop.statisticproxy;

import a_interview.framework.spring.aop.dynamiccproxy.Bye;
import a_interview.framework.spring.aop.dynamiccproxy.ByeInterface;

/**
 * @Author:xuly
 * @Date: 2020/3/16 17:10
 * @Description:
 */
public class ByeProxy implements ByeInterface {
    private ByeInterface byeInterface = new Bye();

    @Override
    public void sayBye() {
        System.out.println("Before invoke sayBye" );
        byeInterface.sayBye();
        System.out.println("After invoke sayBye");
    }
}
