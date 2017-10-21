import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws  InterruptedException{
        ReentrantLockConditionDemo t = new ReentrantLockConditionDemo();
        Thread t1 = new Thread(t);
        t1.start();

        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
