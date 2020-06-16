package LeetCode;

import java.util.Scanner;
public class Main3{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=String.valueOf(n);
        char[] arr=str.toCharArray();
        for(int i=0,k=arr.length-1;i<arr.length/2;i++,k--){
            char temp=arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
        }
        String str1=new String(arr);
        System.out.println(str1);
    }
}

