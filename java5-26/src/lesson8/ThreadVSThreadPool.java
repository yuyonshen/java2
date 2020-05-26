package lesson8;

import java.util.concurrent.*;

public class ThreadVSThreadPool {
    public static void main(String[] args) {


        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//线程核心数
                10,//最大线程数
                60,//空闲时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(1000),//堵塞队列
                new ThreadFactory() {//匿名内部类
                    @Override
                    public Thread newThread(Runnable r) {//线程的工厂类
                        return new Thread(r);
                    }
                },
                //超过队列的容量,之后进行拒绝操作.四个拒接操作
                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
//                new ThreadPoolExecutor.DiscardPolicy()
        );
        pool.execute(() -> {
            System.out.println("送快递到北京");
        });
        pool.execute(() -> {
            System.out.println("送快递到上海");
        });
        pool.execute(() -> {
            System.out.println("干自己的事");
        });
        pool.execute(() -> {
            System.out.println("hao ");
        });
        pool.execute(() -> {
            System.out.println("li");
        });
        pool.execute(() -> {
            System.out.println("hai");
        });
        //单线程池，只有一个正式工，没有零时工，仓库无线
        ExecutorService service=Executors.newSingleThreadExecutor();
        //固定大小的线程池，只有给的那个数量的正式工，没有零时工，仓亏无边界
        ExecutorService service1 = Executors.newFixedThreadPool(4);
        //计划任务线程池，给的那个数量的正式工，没有零时工，使用自己创建的线程的方法
        ScheduledExecutorService servicel2 = Executors.newScheduledThreadPool(4);
        //缓冲线程池：只有零食工，没有正式工，零时工数量无线，空闲事件为60
        ExecutorService service2 = Executors.newCachedThreadPool();

    }
}
