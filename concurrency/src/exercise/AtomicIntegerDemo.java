package exercise;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private  static AtomicInteger count = new AtomicInteger(0);

    public static class addThread implements  Runnable {
        @Override
        public void run() {
            for( int i =0;i<100;i++) {
                count.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[10];
        for(int k =0;k<10;k++) {
            t[k] = new Thread(new addThread());
        }
        for( int j=0;j<10;j++) {
            t[j].start();
        }
        for( int j=0;j<10;j++) {
            t[j].join();
        }
        System.out.println(count);
    }
}
