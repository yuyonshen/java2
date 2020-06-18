package LeetCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=sc.nextInt();
        }
        StringBuffer sb=new StringBuffer();
        if(arr[0]==0){
            for(int i=0;i<10;i++){
                for(int j=1;j<=arr[i];j++){
                    sb.append(i);
                }
            }
            System.out.println(sb.toString());
        }else{
            for(int i=1;i<10;i++){
                if(arr[i]!=0){
                    sb.append(i);
                    arr[i]-=1;
                    break;
                }
            }
            for(int i=0;i<10;i++){
                for(int j=1;j<=arr[i];j++){
                    sb.append(i);
                }
            }
            System.out.println(sb);
        }
    }
}
