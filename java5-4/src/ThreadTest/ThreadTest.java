package ThreadTest;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
创建一个多线程任务.
 */
public class ThreadTest {
    public static void main(String[] args) {
//      //首先我们需要创建一个线程池的工厂类,来创建一个有指定线程个数的工厂
//        ExecutorService es= Executors.newFixedThreadPool(2);
//        //创建一个实现Runnable类接口的类,重写run方法
//        //调用ExecutorService类中提供的方法submit,传递线程任务,开启线程,执行run方法.
//        es.submit(new RunnableTest());
//        es.submit(new RunnableTest());
//        //使用完线程池之后我么那可以调用ExecutorService类中的方法来销毁线程池shutdown方法
//        es.shutdown();
        //实现一个多线程任务我们需要创建一个实现类.来实现那个Runnbale接口.
        RunnableTest r=new RunnableTest();
        //创建一个Thread对象,在构造方法中床底Runnbale接口实现类对象
        Thread t=new Thread(r);
        //使用start()方法开启多线程任务.
        t.start();

        //代码简化
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"创建一个线程");
            }
        };
        new Thread(r1).start();

        //继续简化代码

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"创建一个线程");
            }
        }).start();
    }
}
