package LeetCode;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
//        int i=n/8;
//        int j=n/6;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n/8;i++){
            for(int j=0;j<=n/6;j++){
              if(n==i*8+j*6){
                  min=Math.min(min,i+j);
              }
            }
        }
        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }

    }
}
