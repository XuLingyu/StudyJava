package designpattern.sigeleton;

//、懒汉式，线程不安全
//是否 Lazy 初始化：是
//是否多线程安全：否
//实现难度：易
//描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
//这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
/*public class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/


//双检锁/双重校验锁（DCL，即 double-checked locking）
//JDK 版本：JDK1.5 起
//是否 Lazy 初始化：是
//是否多线程安全：是
//实现难度：较复杂
//描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
public class SingletonLazyInit {
    private volatile static SingletonLazyInit singleton;
    private SingletonLazyInit (){}
    public static SingletonLazyInit getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new SingletonLazyInit();
                }
            }
        }
        return singleton;
    }
}
