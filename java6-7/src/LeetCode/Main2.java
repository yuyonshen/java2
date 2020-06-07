package LeetCode;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if(a>b){
            for(int i=a;i<=a*b;i++){
                if(i/a==0&&i/b==0){
                    System.out.println(i);
                    return;
                }
            }
        }else{
            for(int i=b;i<=a*b;i++){
                if(i/a==0&&i/b==0){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
