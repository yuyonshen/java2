package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/*
验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
例如：
1^3=1
2^3=3+5
3^3=7+9+11
4^3=13+15+17+19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()) {
            int m = sc.nextInt();
            helper(m);
        }
    }

    private static void helper(int m) {
        StringBuffer sb=new StringBuffer();
        if(m%2==0){
            int a=(int)Math.pow(m,2);
            int b=a-1;
            for(int i=1;i<m/2;i++){
                b-=2;
            }
            for(int j=1;j<=m;j++){
                if(j==m){
                    sb.append(b);
                }else {
                    sb.append(b + "+");
                    b += 2;
                }
            }
            System.out.println(sb.toString());
        }else{
            int a=(int)Math.pow(m,2);
            int b=a;
            for(int i=1;i<=m/2;i++){
                b-=2;
            }
            for(int j=1;j<=m;j++){
                if(j==m){
                    sb.append(b);
                }else{
                    sb.append(b+"+");
                    b+=2;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
