package designpattern.sigeleton;

//恶汉是否 ‘
// Lazy 初始化：否
//
//是否多线程安全：是
//
//实现难度：易
//
//描述：这种方式比较常用，但容易产生垃圾对象。
//优点：没有加锁，执行效率会提高。
//缺点：类加载时就初始化，浪费内存。

public class Singleton {

    //创建 SingleObject 的一个对象
    private static Singleton ourInstance = new Singleton();

    //获取唯一可用的对象
    public static Singleton getInstance() {
        return ourInstance;
    }

    //让构造函数为 private，这样该类就不会被实例化
    private Singleton() {
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        Singleton object = Singleton.getInstance();

        //显示消息
        object.showMessage();
    }
}
