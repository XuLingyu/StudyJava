package a_interview.designpattern.structuralmode.proxy.cggllib;

/**
 * @Author: xuly
 * @Date: 2020/9/3 10:13
 * @Description:
 */
public class Target {

    public String execute() {
        String message = "-----------test------------";
        System.out.println(message);
        return message;
    }
}
