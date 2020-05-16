package Thread2;

public class getidTest {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"我还活着");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"我将死去");
        });
        System.out.println(Thread.currentThread().getName()+": ID :"+t.getId());
        System.out.println(Thread.currentThread().getName()+": 名称 :"+t.getName());
        System.out.println(Thread.currentThread().getName()+": 状态 :"+t.getState());
        System.out.println(Thread.currentThread().getName()+": 优先级 :"+t.getPriority());
        System.out.println(Thread.currentThread().getName()+": 后台线程 :"+t.isDaemon());
        System.out.println(Thread.currentThread().getName()+": 是否存活 :"+t.isAlive());
        System.out.println(Thread.currentThread().getName()+": 是否被中断 :"+t.isInterrupted());

        t.start();
        while(t.isAlive()){}
            System.out.println(Thread.currentThread().getName()+": 状态 :"+t.getState());

    }
}
