package designpattern.structuralmode.chain;

/**
 * @Author:xuly
 * @Date: 2019/12/18 17:28
 * @Description:
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
