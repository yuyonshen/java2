package LeetCode;

import java.math.BigInteger;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        BigInteger bg=new BigInteger(s1);
        BigInteger bg2=new BigInteger(s2);
        System.out.println(bg.add(bg2));
        int a=5;
        int s=(a++)+(++a)+(a--)+(--a);
        System.out.println(s);
    }
}
