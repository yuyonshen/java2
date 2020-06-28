package LeetCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            }else {
                set.add(arr[i]);
            }
        }
        for(int x : set){
            System.out.println(x+" ");
        }
    }

}