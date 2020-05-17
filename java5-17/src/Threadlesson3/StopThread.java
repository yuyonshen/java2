package Threadlesson3;

public class StopThread {
    private static int SUM;
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            new Thread(()->{
                for(int J=0;J<10000;J++){
                    SUM++;
                }
            }).start();

        }
        while(Thread.activeCount()>1)
            Thread.yield();//当前线程由运行态转换为就绪态
        System.out.println(SUM);
    }
}
