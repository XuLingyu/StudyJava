package a_interview.designpattern.structuralmode.proxy.cggllib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author: xuly
 * @Date: 2020/9/3 10:14
 * @Description:
 */
public class CglibTest {
    public static void main(String[] args) {
        System.out.println("***************");
        Target target = new Target();
        CglibTest test = new CglibTest();
        Target proxyTarget = (Target) test.createProxy(Target.class);
        String res = proxyTarget.execute();
        System.out.println(res);
    }

    public Object createProxy(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}
