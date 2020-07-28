

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 * 在这里我们可以使用优先级队列来实现.
 */
public class Solution6 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length < k || k < 0){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < input.length; i++){
//            if(i < k){
                queue.offer(input[i]);
//            }else{
//                if(queue.peek() > input[i]){
//                    queue.poll();
//                    queue.offer(input[i]);
//                }
//            }
        }
        ;
        for(int i = 0; i < k; i++){
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr,4));
    }
}
