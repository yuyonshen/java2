package ThreadSafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
保证线程安全我们还可以使用锁来实现多线程的安全
java.util.concurrent.locks.Lock 机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。
 */
public class MyRunnable3 implements Runnable {
    private int num=100;
    //首先创建一个Lock对象
    Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"-->"+num);
                num--;
                lock.unlock();
            }
        }
    }
}
