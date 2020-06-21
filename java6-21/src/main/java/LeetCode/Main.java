package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int start = 0;
//计算n个火车的出站的编号的排列组合
        ArrayList<int[]> result = new ArrayList<int[]>();
        Permutation(arr,start,3,result);
        for(int[] a : result){
            System.out.println(Arrays.toString(a));
        }

    }
    private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result) {
        if (start == n) {
            return;
        }
        if (start == n - 1) {
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for (int i = start; i < n; i++) {
            swap(A, start, i);
            Permutation(A, start + 1, n, result);
            swap(A, start, i);
        }
    }

    private static void swap(int[] a, int start, int i) {
        int temp=a[start];
        a[start]=a[i];
        a[i]=temp;
    }
}
