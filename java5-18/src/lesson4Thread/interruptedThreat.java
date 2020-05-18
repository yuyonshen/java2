package lesson4Thread;

public class interruptedThreat {
    private static class MyRunnable implements  Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("通过异常接收到了中断情况");
            }
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable my=new MyRunnable();
        Thread thread=new Thread(my);
        thread.start();
        thread.interrupt();
    }
}
