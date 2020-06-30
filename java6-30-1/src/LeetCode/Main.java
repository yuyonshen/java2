package LeetCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        char a;
        int b=0;
        int c=0;
       for(int z=0;z<m;z++){
            a = sc.next().charAt(0);
             b = sc.nextInt();
             c = sc.nextInt();
            if(a=='Q'){
                int max=0;
                for(int i=b;i<=c;i++){
                    max=Math.max(max,arr[i]);
                }
                System.out.println(max);
            }else{
                arr[b]=c;
            }

        }
    }
}
