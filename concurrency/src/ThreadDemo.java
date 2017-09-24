public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void  run() {
                System.out.println("This is a thread demo");
            }
        };
        thread.start();
    }

}
