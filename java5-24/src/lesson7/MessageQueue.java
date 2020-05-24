package lesson7;

import java.util.Map;

public class MessageQueue<T> {
    private Object[] table;
    private int putIndex;
    private int takeIndex;
    private int size;

    public MessageQueue(int capacity){
        table=new Object[capacity];
    }
    public void put(T message) throws InterruptedException {
        while (table.length == size) {
            wait();
        }
        table[putIndex] = message;
        size++;
        putIndex = (putIndex + 1) % table.length;
        notifyAll();
    }
    public int take(){
        while(size==0){
            wait();
        }
        Object o=
    }
}
