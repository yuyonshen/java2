package Thread;

public class Queue<T> {
    //模拟一个堵塞队列
    private Object[] table;
    private int putIndex;
    private int takeIndex;
    private int size;
    //初始化一个队列的大小
    public Queue(int capacity) {
       table=new Object[capacity];
    }
    //放元素
    public synchronized void put(T element){
        try {
            while(putIndex==table.length){
                wait();
            }
            table[putIndex]=element;
            putIndex=(putIndex+1)%table.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    //出元素
    public synchronized void take(){
        try {
            while(size==0){
                wait();
            }
            Object o=table[takeIndex];
            takeIndex=(takeIndex+1)%table.length;
            size--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //获取队列的长度
    private synchronized int size(){
        return size;
    }
}
