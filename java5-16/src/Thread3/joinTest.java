package Thread3;

public class joinTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r=()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"我还在工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+": 我结束了!");
        };
        Thread  t=new Thread(r,"李四");
        Thread t2=new Thread(r,"王五");
        System.out.println("先让李四开始工作");
        t.start();
        t.join();
        System.out.println("李四工作结束了让王五开始工作");
        t2.start();
        t2.join();
        System.out.println("王五工作结束了");
    }
}
