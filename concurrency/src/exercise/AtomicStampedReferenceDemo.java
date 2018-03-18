package exercise;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题
 */
public class AtomicStampedReferenceDemo {
    private static AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(19,0);

    public static void main(String[] args) {

        for(int i=0;i<3;i++) {
            final  int timestamp = asr.getStamp();
            new Thread() {
                @Override
                public void run() {
                   while(true) {
                           Integer m = asr.getReference();
                           if(m<20) {
                               if(asr.compareAndSet(m,m+20,timestamp,timestamp+1)) {
                                   System.out.println("更新成功"+asr.getReference());
                                   break;
                               }
                           } else {
                               System.out.println("更新失败");
                               break;
                           }
                   }
                }
            }.start();
        }

        new Thread() {
            @Override
            public void run() {
                for(int i=0;i<6;i++) {
                    while (true) {
                        int timestamp = asr.getStamp();
                        Integer m = asr.getReference();
                        if(m>10) {
                            if(asr.compareAndSet(m,m-10,timestamp,timestamp+1)) {
                                System.out.println("更新成功"+asr.getReference());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的余额");
                            break;
                        }
                    }
                }
            }
        }.start();

    }
}
