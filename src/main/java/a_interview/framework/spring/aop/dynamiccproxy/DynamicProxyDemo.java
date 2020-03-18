package a_interview.framework.spring.aop.dynamiccproxy;

import a_interview.framework.spring.aop.statisticproxy.Hello;
import a_interview.framework.spring.aop.statisticproxy.HelloInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author:xuly
 * @Date: 2020/3/16 16:41
 * @Description: 动态代理
 * 利用反射机制在运行时创建代理类。
 * 接口、被代理类不变，我们构建一个handler类来实现InvocationHandler接口。
 * 通过Proxy类的静态方法newProxyInstance返回一个接口的代理实例。
 *  * 针对不同的代理类，传入相应的代理程序控制器InvocationHandler。
 *  * 如果新来一个被代理类Bye
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloInterface hello = new Hello();
        ByeInterface bye = new Bye();

        InvocationHandler handler = new HelloProxyHandler(hello);
        InvocationHandler handler1 = new HelloProxyHandler(bye);

        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);

        ByeInterface proxyBye = (ByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(), bye.getClass().getInterfaces(), handler1);
        proxyHello.sayHello();
        proxyBye.sayBye();
    }
}
