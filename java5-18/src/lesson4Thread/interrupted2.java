package lesson4Thread;

public class interrupted2 {
    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(Thread.interrupted());
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable my=new MyRunnable();
        Thread t=new Thread(my);
        t.start();
        t.interrupt();
    }
}
