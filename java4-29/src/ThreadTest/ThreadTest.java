package ThreadTest;
//创建一个线程,首先需要继承Thread类,之后重写run方法
public class ThreadTest extends Thread {
    //可以继承父类的构造方法.为线程设置名称
    public ThreadTest(String name){
        super(name);
    }
//    @Override
//    public void run() {
//        for(int i=0;i<20;i++){
//            //获取线程的名称
//            System.out.println(Thread.currentThread().getName()+"-->"+i);
//        }
    //使用getName来实现获取线程名称

    @Override
    public void run() {
        System.out.println(getName());
    }
}

