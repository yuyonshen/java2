package Heap;

import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.Array;
import java.util.*;

class Pair implements Comparable<Pair>{
    public int a;
    public int b;
    public int num;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
        this.num=a+b;
    }
    public int compareTo(Pair o){
        return this.num-o.num;
    }
}

public class Heap {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
            }
        }
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            result.get(i).add(cur.a, cur.b);
        }
        return result;
    }

    //最后石头的重量
    public int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> result = new PriorityQueue<>();
//        for (int i = 0; i < stones.length; i++) {
//            result.offer(stones[i]);
//        }
//        Stack<Integer> result2 = new Stack<>();
//        while (!result.isEmpty()) {
//            result2.push(result.poll());
//        }
//        int add = 0;
//        while (!result2.isEmpty()) {
//            if (add != 0) {
//                result.offer(add);
//            }
//            while (!result.isEmpty()) {
//                result2.push(result.poll());
//            }
//            int a = 0;
//            int b = 0;
//            if (!result2.isEmpty()) {
//                a = result2.pop();
//            }
//            if (!result2.isEmpty()) {
//                b = result2.pop();
//            } else {
//                return a;
//            }
//            if (a == b) {
//                a = b = 0;
//            } else {
//                add = a - b;
//            }
//            result2.clear();
//        }
//    return 0;
//    }
//        int index=stones.length;
//        while(stones.length>1){
//
//        for(int i=0;i<index-1;i++) {
//            for (int j = i + 1; j < index; j++) {
//                if (stones[i] > stones[j]) {
//                    int temp = stones[i];
//                    stones[i] = stones[j];
//                    stones[j] = stones[i];
//                }
//            }
//        }
//        if(stones[index-2]==stones[index-1]){
//            index=index-2;
//        }else{
//            stones[index-1]=stones[index-1]-stones[index-2];
//            index=index-1;
//            for(int )
//        }
//        }
        if(stones.length==1){
            return stones[0];
        }
        int index=stones.length-1;
        Arrays.sort(stones);
        while(stones[index-1]!=0){
            int a=stones[index];
            int b=stones[index-1];
            if(a==b){
                stones[index]=stones[index-1]=0;
            }else{
                stones[index]=a-b;
                stones[index-1]=0;
            }
            Arrays.sort(stones);
        }
        return stones[stones.length-1];
    }
}


        //        while(result.size()>=3){
//            result.poll();
//        }
//        int a=result.poll();
//        int b=result.poll();
//
//        if(a==b){
//            return 0;
//        }else{
//            return b-a;
//        }
//    }


