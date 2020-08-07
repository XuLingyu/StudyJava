package a_interview.designpattern.behavioralmode.strategy;

/**
 * @Author: xuly
 * @Date: 2020/8/7 17:51
 * @Description:
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
