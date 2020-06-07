package LeetCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt();
        int h=sc.nextInt();
       int a=0;
       int b=0;
        if(w%4==0){
            a=w/2;
        }else{
            if(w%4>=2){
                a=(w/4+1)*2;
            }else{
                a=w/4*2+w%4;
            }
        }
        if(h%4==0){
            b=h/2;
        }else{
            if(h%4>=2){
                b=(h/4+1)*2;
            }else{
                b=h/4*2+h%4;
            }
        }
        System.out.println(a*b);
    }
}
