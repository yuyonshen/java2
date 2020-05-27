package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    private BlockingQueue<Runnable > queue;
    //首先创建一个堵塞队列
    public MyThreadPool(int corePoolSize, int capacity){
        //创建仓库
        queue = new ArrayBlockingQueue<>(capacity);
        //招聘员工
        for(int i=0; i<corePoolSize; i++){
            new MyThread(queue).start();
        }

    }
    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static class MyThread extends Thread{
        private BlockingQueue<Runnable> queue;
        public MyThread(BlockingQueue<Runnable> queue) {
            this.queue=queue;
        }

        @Override
        public void run() {
            try {
                while(true){
                    Runnable tesk=queue.take();
                    tesk.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
