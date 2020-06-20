package LeetCode;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] a = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int index=0;
        for(int x : map.keySet()){
            if(map.get(x)%2!=0){
                a[index]=x;
                index++;
            }
        }
      Arrays.sort(a);
        for(int i=0;i<2;i++){
            System.out.print(a[i]+" ");
        }
    }
}
