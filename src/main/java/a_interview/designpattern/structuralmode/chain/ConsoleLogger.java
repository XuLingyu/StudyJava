package a_interview.designpattern.structuralmode.chain;

/**
 * @Author:xuly
 * @Date: 2019/12/18 17:27
 * @Description:
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
