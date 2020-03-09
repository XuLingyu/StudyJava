package designpattern.structuralmode.chain;

/**
 * @Author:xuly
 * @Date: 2019/12/18 17:27
 * @Description:
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
