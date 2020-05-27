package Thread;

import java.util.concurrent.*;

//线程池
public class ThreadPoolVSThread {
    public static void main(String[] args) {
        /*
        1.首先不使用线程完成来送快递
         */
        System.out.println("快递送往北京");
        System.out.println("快递送往上海");
        System.out.println("干自己的事");
        System.out.println("==================");
        /*
        2.使用多线程来完成送快递
        雇佣两个人来送快递,同时自己干自己的事
         */
        new Thread(()->{
            System.out.println("快递送往北京");
        }).start();
        new Thread(()->{
            System.out.println("快递送往上海");
        }).start();
        System.out.println("干自己的事");

        /*
        3使用JDK内置提供线程池来完成送快递任务,同时可以干自己的事
         */
        //创建一个线程池

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//核心线程数
                10,//最大线程数
                60,//空闲时间数
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(1000),//创建一个堵塞队列
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                //队列达到最大容量的时候,进行决绝客服进入队列
                new ThreadPoolExecutor.DiscardPolicy()
               //抛出异常的方式
                // new ThreadPoolExecutor.AbortPolicy()
               //execute的代码块,交给自己,自己去执行
                //new ThreadPoolExecutor.CallerRunsPolicy()
        //吧最旧的线程丢掉
        //new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        //进入队列中
        pool.execute(()->{
            System.out.println("快递送往北京");
        });
        pool.execute(()->{
            System.out.println("快递送往上海");
        });
        pool.execute(()->{
            System.out.println("干自己的事");
        });
    }
}
