package Threadlesson3;

public class Myrunnable implements Runnable {
    private static int sum=100;
    @Override
    public void run() {
        while(true){
            if(sum>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+sum--);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new Myrunnable(),"线程一");
        t1.start();
        Thread t2=new Thread(new Myrunnable(),"线程二");
        t2.start();
        Thread t3=new Thread(new Myrunnable(),"线程三");
        t3.start();
        Thread t4=new Thread(new Myrunnable(),"线程四");
        t4.start();
    }
}
