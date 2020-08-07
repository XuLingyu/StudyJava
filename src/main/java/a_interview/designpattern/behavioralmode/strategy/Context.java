package a_interview.designpattern.behavioralmode.strategy;

/**
 * @Author: xuly
 * @Date: 2020/8/7 17:51
 * @Description:
 */
public class Context {
    private Strategy strategy;

    public Context(){
    }

    public void setStrategy (Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
