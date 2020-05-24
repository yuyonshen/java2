package Thread;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class ThreadTest {
    //单列模式
    //1.饿汉模式
    //在类加载的时候都创建对象了.
    //在内存中使用的时候直接传参
    private static ThreadTest instance=new ThreadTest();
    private ThreadTest(){}
    public static ThreadTest getInstance(){
        return instance;
    }
}
//懒汉模式-单线程
//懒汉模式在类加载的时候没有创建对象
//在调用的时候在new对象
class Singletion{
    private static Singletion instance;
    private Singletion(){}
    public static Singletion getInstance(){
        if(instance==null){
            new Singletion();
        }
        return instance;
    }
}
/*
懒汉模式多线程模式
/这个多线程执行的时候效率比较低.
每个线程都需要=竞争对象锁,之后进去判断是否new对象
 */
class Singletion2{
    private static Singletion2 instance;
    private Singletion2(){};
    public static Singletion2 getInstance(){
        for(int i=0;i<5;i++) {
            new Thread(() -> {
                synchronized (Singletion2.class){
                    if(instance==null){
                        new Singletion2();
                    }
                }
            }).start();
        }
        return instance;
    }
}
//懒汉模式 - 多线程优化
//双层if 判断可以解决多线程懒汉模式的优化问题
//后面的进入的线程之后进行if判断之后就不用进入锁中判断了
//可以提过效率
class Singletion3{
    private static Singletion2 instance;
    private Singletion3(){};
    public static Singletion2 getInstance(){
        for(int i=0;i<5;i++) {
            new Thread(() -> {
                if(instance==null) {
                    synchronized (Singletion3.class) {
                        if (instance == null) {
                            new Singletion3();
                        }
                    }
                }
            }).start();

        }
        return instance;
    }
}

