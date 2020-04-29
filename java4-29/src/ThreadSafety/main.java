package ThreadSafety;

public class main {
    private static Object obj=new Object();
    public static void main(String[] args) {
//        MyRunnable3 r=new MyRunnable3();
//        //实现三个线程
//        Thread t=new Thread(r,"线程1");
//        Thread t2=new Thread(r,"线程2");
//        Thread t3=new Thread(r,"线程3");
//        t.start();
//        t2.start();
//        t3.start();
        //实现一个writin个无线等待的代码
        //例如一个包子铺
        //包子铺中有乘客和老板
        //首先创建一个乘客线程,乘客线程执行吃包子

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("告知老板需要吃包子");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        //现在创建一个包子铺线程
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("包子做好了,可以吃包子了");
                        obj.notify();
                    }
                }

            }
            }.start();

    }

}
