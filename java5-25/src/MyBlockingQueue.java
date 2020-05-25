public class MyBlockingQueue<T> {
    private Object[] table;
    private int putIndex;
    private int takeIndex;
    private int size;

    public MyBlockingQueue(int catpacity) {
        table = new Object[catpacity];
    }

    //存放数据
    public synchronized void put(T element) throws InterruptedException {
        if (table.length == size) {
            wait();
        }
        table[putIndex] = element;
        size++;
        putIndex = (putIndex + 1) % table.length;
        notifyAll();
        Thread.sleep(500);
    }

    //取元素
    public synchronized T take() throws InterruptedException {
        if (size == 0) {
            wait();
        }
        Object element = table[takeIndex];
        size--;
        takeIndex = (takeIndex + 1) % table.length;
        notifyAll();
        Thread.sleep(500);
        return (T) element;
    }

    private synchronized int size() {
        return size;
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        //生产者
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (queue) {
                        try {
                            queue.put(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("存放面包+1:" + queue.size());
                    }
                }
            }).start();

        }
        //消费者
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (queue) {
                        try {
                            queue.take();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费面包-1:" + queue.size());
                    }
                }
            }).start();
        }
    }
}
