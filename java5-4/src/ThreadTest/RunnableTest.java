package ThreadTest;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        //创建一个实现Runnable类接口的类,重写run方法
        System.out.println(Thread.currentThread().getName()+"执行这个线程任务");
    }
}
