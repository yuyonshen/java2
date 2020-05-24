package Thread;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ThreadDome {
    private static int SUM;
    public static void main(String[] args) {
       //生产者
        for(int i=0;i<5;i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (ThreadDome.class) {
                            if (SUM + 3 > 100) {
                                ThreadDome.class.wait();
                            } else {
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName() + "生产了:" + SUM+"包子");
                                Thread.sleep(200);
                            }
                        }
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"生产者"+i).start();
        }
        //消费者
        for(int i=0;i<20;i++){
            new Thread(()->{
                while(true){
                    synchronized (ThreadDome.class){
                        if(SUM==0){
                            try {
                                ThreadDome.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else{
                            SUM--;
                            System.out.println(Thread.currentThread().getName()+"吃了:"+SUM+"包子");
                            ThreadDome.class.notifyAll();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"消费者"+i).start();
        }
    }
}
