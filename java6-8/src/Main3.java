import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main3{
    /*
    标题：n个数里出现次数大于等于n/2的数 | 时间限制：1秒 | 内存限制：32768K
输入n个整数，输出出现次数大于等于数组长度一半的数。
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] a=str.split(" ");
        int[] arr=new int[a.length];
        for(int i=0;i<a.length;i++){
            arr[i]=Integer.parseInt(a[i]);
//            int min=Integer.MIN_VALUE;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int x : arr){
           map.put(x,map.getOrDefault(x,0)+1);
        }
        int n=arr.length/2;
        int ret=0;
       for(Map.Entry<Integer,Integer>entry:map.entrySet()){
           if(entry.getValue()>=n){
               ret=entry.getKey();
           }
       }
        System.out.println(ret);
    }
}
