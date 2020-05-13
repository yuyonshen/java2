package ProgrammingProblem;

import java.util.Random;

public class ThreadPop implements Runnable {
    private StackInterface s;

    public ThreadPop(StackInterface s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("----->"+s.pop()[0]+"<-------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
 class PushThread implements Runnable{
    private StackInterface s;

    public PushThread(StackInterface s) {
        this.s = s;
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            Random r=new Random();
            i=r.nextInt(10);
            try {
                s.push(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
