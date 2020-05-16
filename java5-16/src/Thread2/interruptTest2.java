package Thread2;


public class interruptTest2 implements Runnable {
    @Override
    public void run() {
        while(!Thread.interrupted()){
            System.out.println(Thread.currentThread().getName()+":别管我我正在转钱");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

        }
        System.out.println(Thread.currentThread().getName()+"呀:差点被骗了");

    }
}
