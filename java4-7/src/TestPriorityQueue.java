import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        //堆的应用-标准库中提供的优先级队列
        //标准库中提供额优先级队列,是按照小堆进行排序的
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        //现在开始后出队列
        while(!queue.isEmpty()){
            int a=queue.poll();
            System.out.print(a+" ");
        }

    }
}
