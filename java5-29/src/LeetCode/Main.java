package LeetCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        输入包括五行。
第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。

输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
         */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] x1=new int[n];
        int[] y1=new int[n];
        int[] x2=new int[n];
        int[] y2=new int[n];
        for(int i=0;i<n;i++){
            x1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
           y1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            x2[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
             y2[i]=sc.nextInt();
        }
        int cnt=0;
        for(int x  :  x1){
            for(int y : y1){
                int temp=0;
                for(int i=0;i<n;i++){
                    if(x1[i]<=x&&x<x2[i]&&y1[i]<=y&&y<y2[i]){
                        temp++;
                    }
                }
                cnt=Math.max(cnt,temp);
            }

        }
        System.out.println(cnt);
    }
}
