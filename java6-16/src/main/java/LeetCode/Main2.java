package LeetCode;

import java.util.Scanner;

/*
1. 标题：末尾0的个数 | 时间限制：1秒 | 内存限制：32768K
输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
输入描述：
输入为一行，n(1 ≤ n ≤ 1000)
输出描述：
输出一个整数,即题目所求
示例1:
输入
10
输出
2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int num=0;
        for(int i=1;i<=n;i++){
            int tem=i;
            while(tem%5==0){
                num++;
                tem=tem/5;
            }
        }
        System.out.println(num);
    }
}
