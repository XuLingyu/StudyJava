package a_interview.framework.spring.aop.dynamiccproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:xuly
 * @Date: 2020/3/16 16:40
 * @Description:
 * 动态代理
 *  * 利用反射机制在运行时创建代理类。
 *  * 接口、被代理类不变，我们构建一个handler类来实现InvocationHandler接口。
 *  * 通过Proxy类的静态方法newProxyInstance返回一个接口的代理实例。
 *  *  * 针对不同的代理类，传入相应的代理程序控制器InvocationHandler。
 *  *  * 如果新来一个被代理类Bye
 */
public class HelloProxyHandler implements InvocationHandler {
    private Object object;
    public HelloProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
