package ThreadTest;
//加入线程的第二中方法
//实现Runnable接口
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
