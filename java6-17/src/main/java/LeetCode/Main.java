package LeetCode;


import java.util.*;

public class Main {
    public int addAB(int A, int B) {
        int a=0;
        for(int i=1;i<=A;i++){
            a++;
        }
        int b=a;
        for(int i=1;i<=B;i++){
            b++;
        }
        return b;
    }

    public static void main(String[] args) {
        Main m=new Main();
        System.out.println(m.addAB(12,20));
    }


}