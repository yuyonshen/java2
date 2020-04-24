package ThreatTest;
/*
创建线程的方法可以有两种其中第一种方法为
1.首先需要子类继承Thread这个父类
2.java.long.Thread:这个类时描述进程的类,我们想要实现多线程必须继承Thread
 创建多线程
    1.创建一个Thread子类
    2.在Thread子类的方法中需要重写run这个方法,设置线程任务(需要做什么)
    3.创建子类对象
    4.调用Thread类中的start方法,开启行的线程,来执行run方法
java程序属于抢占式调度,那个优先级高限高就先执行那个线程,优先级相同,则随机执行.
 */
public class TestThreat {
    public static void main(String[] args) {
        MyThreat threat=new MyThreat();
        threat.start();
        for(int i=0;i<20;i++){
            System.out.println("main"+ i);
        }
    }

}
class MyThreat extends Thread{
    public void run(){
        for(int i=0;i<20;i++){
            System.out.println("run"+ i);
        }
    }
}
