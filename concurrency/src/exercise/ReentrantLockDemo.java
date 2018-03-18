package exercise;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;
    @Override
    public void run() {
        for (int j=0;j<10000;j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demoThread = new ReentrantLockDemo();
        Thread t1 = new Thread(demoThread);
        Thread t2 = new Thread(demoThread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
