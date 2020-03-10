package a_interview.designpattern.creationalmode.sigeleton;

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


/*
懒汉式，线程安全
是否 Lazy 初始化：是

是否多线程安全：是

实现难度：易

描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
优点：第一次调用才初始化，避免内存浪费。
缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。*/
/*public class Singleton {
    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
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
//描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能 getInstance() 的性能对应用程序很关键。

// 双重检查锁（double checked locking）:先判断对象是否已经被初始化，再决定要不要加锁。()
public class SingletonLazyInit {

    // 用static 编译器为了性能会可能拿到初始化未完成的对象 volatile的话会从内存及时获取
    private volatile static SingletonLazyInit singleton;
    private SingletonLazyInit (){}
    public static SingletonLazyInit getInstance() {
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
