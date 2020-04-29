package ThreadSafety;
//实现一个买电影票的窗口线程
//当为一个线程的时候不需要考虑线程安全问题,实现一个多窗口买票线程的时候我们需要考虑线程安全问题
//首先需要实现一个Runnable接口
public class MyRunnable  implements Runnable{
    //假设一共有100张票
    private  int num=100;

    //实现一个死循环
//
//    @Override
//    public void run() {
//
//        while (true) {
//
//            if (num > 0) {
//                try {
//                    //Threat类中提个了一个静态属性的方法sleep()方法.当线程进入run之后睡眠10毫秒
//                    //这样也可以为了保证线程安全问题
//                    //但是当票剩下只剩一张飘得时候,三个线程就进入了run
//                    //方法,这样都会出现0,挥着-1这样也是出现了错误.
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"正在售卖"+num--);
//            }
//        }
    //为了保证线程安全我们引入了同步代码块
    //使用同步代码块,需要关键字  synchronized
    //使用方法
    /*
    synchronized(同步锁){
    需要同步操作的代码块
    }
    同步锁: 所谓香可以任意对象
            多线程使用同步锁的时候需要同一个同步锁
    */
    Object obj=new Object();
    @Override

    public void run() {
        while(true){
            synchronized (obj) {
                if (num > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-->" + num);
                    num--;
                }
            }
    }
}
}
