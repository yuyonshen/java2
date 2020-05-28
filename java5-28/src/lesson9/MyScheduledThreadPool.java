package lesson9;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class MyScheduledThreadPool {
    //员工
    private MyTimer[] threads;
    //仓库
    private PriorityBlockingQueue<MyTimerTask> queue=new PriorityBlockingQueue<>();
    public MyScheduledThreadPool(int capacity){
        threads=new MyTimer[capacity];
        for(int i=0;i<capacity;i++){
           //传参将队列传入进去
            threads[i]=new MyTimer(queue);
            threads[i].start();
        }
    }
    //执行定时任务的方法:任务,延迟时间,间隔时间
    public void schedule(Runnable runnable,long delay,long period){
        MyTimerTask task=new MyTimerTask(runnable,new Date().getTime()+delay,period);
        synchronized (queue) {
            queue.put(task);
            queue.notifyAll();
        }
    }
    //员工
    private static class MyTimer extends Thread{
        private PriorityBlockingQueue<MyTimerTask> queue;
        public MyTimer(PriorityBlockingQueue<MyTimerTask> queue) {
            this.queue=queue;
        }
        @Override
        public void run() {
            while(true){

                MyTimerTask task= null;
                try {
                    task = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue){
                        long current=System.currentTimeMillis();
                        if(current <task.next){
                            try {
                                queue.wait(task.next-current);
                                queue.put(task);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            task.run();
                            if (task.period > 0) {
                                task.next = task.next + task.period;//下次执行时间修改为当前的next+period
                                queue.put(task);
                            }
                        }
                    }
            }
        }
    }
    //定时任务
    private static class MyTimerTask implements Runnable,Comparable<MyTimerTask>{
        private Runnable runnable;
        private long next;//下次执行时间
        private long period;//间隔时间
        public MyTimerTask(Runnable runnable, long next, long period) {
            this.next=next;
            this.period=period;
            this.runnable=runnable;
        }

        @Override
        public void run() {
            runnable.run();
        }

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next,o.next);
        }
    }
}
