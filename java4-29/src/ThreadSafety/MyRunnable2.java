package ThreadSafety;

public class MyRunnable2 implements Runnable {
    /*
    为了保证线程安全我们还可以使用同步方法来实现线程安全
    修饰符 synchronized 返回值类型 方法名(参数列表){
        同步代码块
    }
     */
    private int num=100;
    @Override
    public void run() {
        while(true){
            method();
        }
    }
    //使用同步代码块来实现线程安全
    public synchronized void method(){
        if(num>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->" +num);
            num--;
        }
    }
}
