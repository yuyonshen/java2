package Examination;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
           int z= f(n);
            System.out.println(z);
        }
    }

    private static int f(int n) {
        int f1=0;
        int f2=1;
        int f=0;
        while(n>=f){
            if(n==f){
                return 0;
            }
            f=f1+f2;
            f1=f2;
            f2=f;
        }
        int a=f2-n;
        int b=n-f1;
        if(a>b){
            return b;
        }
        return a;

    }
}
