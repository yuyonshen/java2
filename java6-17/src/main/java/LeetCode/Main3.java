package LeetCode;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String x=sc.next();
        for(int i=1;i<=n;i++){
            System.out.print(x);
        }
        System.out.println();
        for(int i=2;i<(Math.ceil(n))/2;i++){
            System.out.print(x);
            for(int j=2;j<n;j++){
                System.out.print(" ");
            }
            System.out.print(x);
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            System.out.print(x);
        }
    }

}
