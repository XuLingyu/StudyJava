package Exams.Thread;

import java.util.Random;

public class Producer implements Runnable{
    ConsumerProducerStack<Character> stack;
    String name;
    public Producer(ConsumerProducerStack<Character> stack, String name) {
        this.name=name;
        this.stack=stack;
    }
    public void run() {
        while(true) {
            try {
                Thread.sleep(1600);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            char c=getC();
            stack.push(c);
            System.out.println(name+" 压入:"+c);

        }
    }
    public static char getC() {
        return (char) (new Random().nextInt('Z'-'A'+1)+'A');
    }
}
