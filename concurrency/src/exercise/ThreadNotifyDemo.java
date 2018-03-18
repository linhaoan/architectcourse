
package exercise;
public class ThreadNotifyDemo {


    public static void main(String[] args) {

        final Object object = new Object();

        Thread t1 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T1 start!");
                    try {
                        System.out.println("T1 wait for object");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1 end!");
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T2 start!");
                    object.notify();
                    System.out.println("T2 end!");
                }
            }
        };
        //如果t2先启动，会导致t1挂起
        //TODO t2->t1 bug
        t1.start();
        t2.start();
    }
}
