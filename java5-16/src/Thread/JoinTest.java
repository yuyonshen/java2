package Thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
       Thread t= new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("Thread body");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
       t.start();
       t.join(1000);
        System.out.println("main");
    }
}
