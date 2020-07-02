import java.util.*;
public class Main3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        h(arr,n,0,/*(long)*/0,sum);
        System.out.println(num);
    }
    static int num=0;
    private static void h(int v[],int n,int i,long sum,int w){
       if(i>=n){
           return ;
       }
       if(sum==w){
           num++;
       }
        if (sum>w)//总数超过背包载重，不再向后
            return;
        h(v,n,i+1,sum,w);//第i个不放入
        h(v,n,i+1,sum+v[i],w);//第i个放入
    }
}