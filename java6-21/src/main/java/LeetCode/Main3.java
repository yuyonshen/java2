package LeetCode;

import java.util.Scanner;

public class Main3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int f=sc.nextInt();
        String[] s=new String[n];
        int[] arr=new int[n];
        int a=0;
       for(int i=0;i<n;i++){
           s[i]=sc.next();
           arr[i]=sc.nextInt();
       }
        if(f==0) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        String s1 = s[i];
                        s[i] = s[j];
                        s[j] = s1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(s[i] + " " + arr[i]);
            }
        }
    }
}
