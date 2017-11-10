package chapter1;
/**
 * -Xss2M
 *
 */
public class JavaVMStackOOM {
	
	private void doStop() {
		while (true) {
			
		}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					doStop();
					
				}
				
			});
			thread.start();
		}
	}
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
