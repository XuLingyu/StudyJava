package a_interview.designpattern.structuralmode.proxy;

/**
 * @Author:xuly
 * @Date: 2019/12/18 15:29
 * @Description: 我们将创建一个 Image 接口和实现了 Image 接口的实体类。
 * ProxyImage 是一个代理类，减少 RealImage 对象加载的内存占用。
 * ProxyPatternDemo，我们的演示类使用 ProxyImage 来获取要加载的 Image 对象，并按照需求进行显示。
 */
public interface Target {
    public String execute();
}

class TargetImpl implements Target {

    @Override
    public String execute() {
        System.out.println("TargetImpl execute！");
        return "execute";
    }
}

public class Proxy implements Target{

    private Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    @Override
    public String execute() {
        System.out.println("perProcess");
        String result = this.target.execute();
        System.out.println("postProcess");
        return result;
    }
}

class Proxy implements Target{

    private Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    @Override
    public String execute() {
        System.out.println("perProcess");
        String result = this.target.execute();
        System.out.println("postProcess");
        return result;
    }
}

class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
