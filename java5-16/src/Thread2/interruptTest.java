package Thread2;
 class MyRunnable implements Runnable {
     public volatile boolean isQuit = false;

     @Override
     public void run() {
         while (!isQuit) {
             System.out.println(Thread.currentThread().getName() + ": 别管我,我正在转账");
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         System.out.println(Thread.currentThread().getName() + ": 呀,险些误大事了");
     }
 }
public  class interruptTest {
    public static void main(String[] args) throws InterruptedException {
      MyRunnable my=new MyRunnable();
      Thread t=new Thread(my,"李四");
      t.start();
      Thread.sleep(1000*10);
        System.out.println(Thread.currentThread().getName()+"老板来电话了,得赶紧通知李四对方是骗子");
        my.isQuit=true;
    }


}
