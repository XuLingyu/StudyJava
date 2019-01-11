package Exams.Thread;

public class Consumer implements Runnable {
    ConsumerProducerStack<Character> stack;
    String name;
    public Consumer(ConsumerProducerStack<Character> stack, String name) {
        this.stack=stack;
        this.name=name;
    }
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            char c=stack.pull();
            System.out.println(name+" 弹出:"+c);
            System.out.print(stack.getSize());

        }
    }
}
