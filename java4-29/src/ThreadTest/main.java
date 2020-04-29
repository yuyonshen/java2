package ThreadTest;
//使用测试方法
public class main {
    public static void main(String[] args) {
//        ThreadTest t=new ThreadTest();
//        t.start();
//        for(int i=0;i<20;i++){
//            System.out.println(Thread.currentThread().getName()+"-->"+i);
//        }
        //在实现Runnable接口的时候我们需要使用Thread类对象来事项这个接口
//        MyRunnable r=new MyRunnable();
//        Thread t=new Thread(r);
//        t.start();
//        ThreadTest t=new ThreadTest("小强");
//        t.start();
        //匿名内部类实现多线程
        Runnable r=new Runnable(){
            @Override
            public void run() {
                System.out.println("哈哈");
            }
        };
        new Thread(r).start();
    }
}
