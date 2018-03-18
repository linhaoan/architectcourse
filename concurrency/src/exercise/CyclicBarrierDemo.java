package exercise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	private static CyclicBarrier cb = new CyclicBarrier(5);
	public static class Soldier implements Runnable {

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getId()+" collect ");
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		Soldier soldier = new Soldier();
		for(int i=0;i<20;i++) {
			threadPool.execute(soldier);
		}
		cb.await();
		System.out.println(" collect done");
		
		
	}

}
