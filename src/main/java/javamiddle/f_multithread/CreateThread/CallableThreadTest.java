package javamiddle.f_multithread.CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * Callable和Runnable有几点不同：
 * （1）Callable规定的方法是call()，而Runnable规定的方法是run().
 * （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
 * （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
 * （4）运行Callable任务可拿到一个Future对象，
 * <p>
 * Created by lxk on 2017/6/27
 */
public class CallableThreadTest implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);//毫秒
				sum += 1;
				System.out.println(Thread.currentThread().getName() + "...implements Callable<T>..." + sum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int resultFromThread;
		try {
			CallableThreadTest test = new CallableThreadTest();
			FutureTask<Integer> future = new FutureTask<>(test);
			new Thread(future).start();
			Thread.sleep(5000);// 可能做一些事情
			//注意：
			// 这个有个问题：主线程必须等子线程执行完，才可以继续执行，变成了同步啦，这就不太好啦。失去了多线程的意义啦。
			resultFromThread = future.get();
			System.out.println(Thread.currentThread().getName() + "...implements Callable<T>..." + resultFromThread);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
