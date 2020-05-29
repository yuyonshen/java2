package Thread;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

//创建一个定时任务池
public class MyScheduledThreadPool {
    private MyThread[] threads;
    //创建一个队列
    private PriorityBlockingQueue<MyTimerTask> queue=new PriorityBlockingQueue<MyTimerTask>();
    public MyScheduledThreadPool(int capacity){
        threads=new MyThread[capacity];
        for(int i=0;i<capacity;i++){
            threads[i]= new MyThread(queue);
            threads[i].start();
        }
    }
    //执行定时任务,延迟时间,间隔时间
    public void schedule(Runnable runnable, long delay, long period){
        MyTimerTask task = new MyTimerTask(runnable, new Date().getTime()+delay, period);
        synchronized (queue){
            queue.put(task);
            queue.notifyAll();
        }
    }

    private static class MyThread extends Thread{
        private PriorityBlockingQueue<MyTimerTask> queue;
        public MyThread(PriorityBlockingQueue<MyTimerTask> queue) {
            this.queue=queue;
        }
        @Override
        public void run() {
           // while(true){
                try {
                    MyTimerTask task=queue.take();
                        synchronized (queue){
                        long current=System.currentTimeMillis();
                        if(current<task.next){
                            queue.wait(task.next-current);
                            queue.put(task);
                        }else{
                            task.run();
                            task.next = task.next + task.period;//下次执行时间修改为当前的next+period
                            queue.put(task);


                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
               // }
            }
        }
    }
    //设置定时任务
    private static class MyTimerTask<compareTo> implements Runnable,Comparable<MyTimerTask>{
        private Runnable runnable;
        private long next;
        private long period;

        public MyTimerTask(Runnable runnable, long next, long period) {
            this.runnable = runnable;
            this.next = next;
            this.period = period;
        }

        @Override
        public void run() {
            runnable.run();
        }
        @Override
        public int compareTo(MyTimerTask o) {

            return Long.compare(next, o.next);
        }
    }

    public static void main(String[] args) {
        MyScheduledThreadPool scheduled=new MyScheduledThreadPool(4);
        scheduled.schedule(()->{
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(d));

        },1,1000);
    }
}
