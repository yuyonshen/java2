package LeetCode;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main3 {
    /*
    牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
牛牛希望你能帮他计算一共有多少个可能的数对。
输入描述:
输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
输出描述:
对于每个测试用例, 输出一个正整数表示可能的数对数量。
     */
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        int k=scanner.nextInt();
//        List<Integer> list=new ArrayList<>();
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n;j++){
//                    list.add(i);
//                    list.add(j);
//    }
//        }
//
//        int reslut=0;
//        for(int i=0;i<list.size();i+=2){
//
//            int a=list.get(i);
//            int b=list.get(i+1);
//            if(a%b>=k){
//                reslut++;
//            }
//        }
//        System.out.println(reslut);

        Scanner scanner=new Scanner(System.in);
        long n=scanner.nextInt();
        long k=scanner.nextInt();
        int reslut=0;
        for(long i=1;i<=n;i++){
            for(long j=1;j<=n;j++){
                if(i%j>=k){
                    reslut++;
                }
            }
        }
        System.out.println(reslut);
    }
}
