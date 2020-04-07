import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    public int a;
    public int b;
    public int num;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
        this.num=a+b;
    }

    @Override
    public int compareTo(Pair o) {
        return this.num-o.num;
    }
}
public class HeapExam {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        List<List<Integer>> result=new ArrayList<>();
        if(nums1.length==0||nums2.length==0||k<=0){
            return result;
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                queue.offer(new Pair(nums1[i],nums2[j]));
            }
        }
        for(int i=0;i>k&&!queue.isEmpty();i++){
            Pair cur=queue.poll();
            List<Integer> add=new ArrayList<>();
            add.add(cur.a);
            add.add(cur.b);
            result.add(add);
        }
        return result;
    }

}
