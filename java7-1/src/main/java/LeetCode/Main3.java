package LeetCode;

import java.util.*;
public class Main3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int max = (int) Math.pow(n, 2);
            int a = n;
            StringBuffer sb = new StringBuffer();
            int b=0;
            int c=0;
            while (a > 0) {
                if (a % 10 != max % 10) {
                    System.out.println("No");
                }
                b=b*10+a%10;
                c=c*10+max%10;
                a = a / 10;
                max = max / 10;
            }
            if(c==b){
                System.out.println("Yes");
            }
        }
    }
}
