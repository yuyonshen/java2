package Thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class threadTest {
    //首先观察main堵塞
    public static void main(String[] args) throws InterruptedException {
      //  Thread.sleep(999999999999999999L);
        //在子线程中让子线程堵塞
//        new Thread( new Runnable(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(999999999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血").start();
        //子线程和主线程都堵塞
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(99999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第二滴血").start();
//        Thread.sleep(9999999999999L);
        //main线程中调用run方法
//            Thread t=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(99999999999999L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }) ;
//            t.run();
        //main和子程序同时运行,观察先打印哪一个
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }).start();
        System.out.println("main");
    }
}
