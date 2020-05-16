package Thread;

public class myThread  extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t=new Thread();
        t.start();
    }
}
