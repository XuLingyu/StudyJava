package a_interview.designpattern.behavioralmode.strategy;

/**
 * @Author: xuly
 * @Date: 2020/8/7 17:51
 * @Description:
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
