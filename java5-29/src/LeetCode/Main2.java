package LeetCode;

import java.util.Scanner;

public class Main2 {
    /*
    每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
数据保证至少有一个闹钟可以让牛牛及时到达教室。
输出描述:
输出两个整数表示牛牛最晚起床时间。
示例1
输入
复制
3
5 0
6 0
7 0
59
6 59
输出
复制
6 0
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] hours=new int[n];
        int[] minuts=new int[n];
        for(int i=0;i<n;i++){
            hours[i]=sc.nextInt();
            minuts[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        int A=sc.nextInt();
        int B=sc.nextInt();
        int index=0;
        int a=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(hours[i]<=A){
                int temp=(A-hours[i])*60+B-minuts[i];
                if(temp>=x&&temp<a){
                    a=temp;
                    index=i;
                }
            }
        }
        System.out.println(hours[index]+" "+minuts[index]);
    }
}
