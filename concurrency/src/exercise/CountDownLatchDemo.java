package exercise;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable{

	static final CountDownLatch count = new CountDownLatch(10);
	static final CountDownLatchDemo demo = new CountDownLatchDemo();
	@Override
	public void run() {
		
		try {
			Thread.sleep(new Random().nextInt(10)*1000);
			System.out.println(Thread.currentThread().getId()+" is done");			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			count.countDown();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		for(int i =0;i<10;i++) {
			threadPool.execute(demo);
		}
		
		//�ȴ����
		count.await();
		//������
		System.out.println("fire");
		threadPool.shutdown();
	}
}
