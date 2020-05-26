package lesson8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    //仓库
    private BlockingQueue<Runnable> queue;

    public MyThreadPool(int corePoolSize,int capacity) {
        queue=new ArrayBlockingQueue<>(capacity);
        //招聘员工
        for(int i=0;i<corePoolSize;i++){
            new MyThread(queue).start();
        }
    }
    //客户派送快递：仓库保存存放包裹
    public void execute(Runnable tesk){
        try {
            queue.put(tesk);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //正式员工一直干活
    private static class  MyThread  extends Thread{
        private BlockingQueue<Runnable> queue;
        public MyThread(BlockingQueue<Runnable> queue) {
            this.queue=queue;
        }

        @Override
        public void run() {
            try {
                while(true){
                    Runnable task=queue.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
