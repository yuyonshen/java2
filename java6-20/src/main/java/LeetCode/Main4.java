package LeetCode;

import java.util.*;
public class Main4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(i==0){
                System.out.print(-1+" ");
            }
            int left=i-1;
            int right=i+1;
            while(left>=0){
                if(arr[left]<arr[i]){
                    System.out.print(left+" ");
                    break;
                }else if(left==0){
                    System.out.print(-1+" ");
                }
                left--;
            }
            while(right<n){
                if(arr[right]<arr[i]){
                    System.out.println(right);
                    break;
                }else if(right==n-1){
                    System.out.println(-1);
                }
                right++;
            }
            if(i==n-1){
                System.out.println(-1+" ");
            }
        }
    }
}
