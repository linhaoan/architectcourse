package architectcourse.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable{
	
	final Semaphore semaphore = new Semaphore(5);

	@Override
	public void run() {
		try {
			semaphore.acquire();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId()+"is done");
		}catch (Exception e) {
			e.printStackTrace();
		} finally { 
			semaphore.release();
		}	
	}

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		final SemaphoreDemo  s = new SemaphoreDemo();
		for (int i=0;i<20;i++) {
			threadPool.submit(s);
		}
		threadPool.shutdown();
	}
}
