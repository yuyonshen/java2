package LeetCode;

import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int num=sc.nextInt();
            int[] arr=new int[n];
            int index=num;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                if(index>arr[i]){
                    index=index+arr[i];
                }else{
                   int a= helply(index,arr[i]);
                   index=index+a;
                }
            }
            System.out.println(index);
        }
    }

    private static int  helply(int num, int i) {
        int a=0;
        for(int j=num;j>0;j--){
                if(num%j==0&&i%j==0){
                    a=j;
                    break;
                }
            }
        return a;
    }
}
