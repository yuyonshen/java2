package LeetCode;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=sc.nextInt();
        char[] arr=str.toCharArray();
        int max=0;
        String s=null;
        for(int i=0;i<arr.length-n;i++){
            int index=0;
            int num=0;
            for(int j=i;j<arr.length;j++){
                num++;
                if(num<=n) {
                    if (arr[j] == 'G' || arr[j] == 'C') {
                        index++;
                    }
                }
            }
            if(max<index){
                max=Math.max(max,index);
                s=str.substring(i,i+n);
            }
        }
        System.out.println(s);
    }
}