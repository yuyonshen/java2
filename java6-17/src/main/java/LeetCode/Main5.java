package LeetCode;

import java.util.*;
public class Main5{
    public static void main(String[] ags){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int N=sc.nextInt();
            if(N==0){
                break;
            }
            int[] arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            int index=sc.nextInt();
            int a=0;
            for(int i=0;i<N;i++){
                if(arr[i]==index){
                    a++;
                }
            }
            System.out.println(a);
        }
    }
}
