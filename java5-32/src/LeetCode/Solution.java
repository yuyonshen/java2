package LeetCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    //古典问题:有一堆兔子,从出生后的第三个月其没有个都生一对兔子,小兔子长到三个月之后又每个雨
    //有生一对兔子,加入兔子都不死,问每每个月的兔子总数
    public int Fibracci(int n){
        if(n==1||n==2){
            return 2;
        }
        return (Fibracci(n-1)+ Fibracci(n-2));
    }

    //判断101到200之间有多少个素数,并输出所有的素数
    public void Prime(){
        int num=0;
        for(int i=102;i<=200;i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
               break;
                }else{
                    if(j==i-1){
                        System.out.println(i);
                    }
                }
            }

        }
    }
    //找出三位数的所有水花仙数
public void count(){
        for(int i=100;i<1000;i++){
            int a=i%10;
            int b=i/10%10;
            int c=i/100;
            if((Math.pow(a,3)+ Math.pow(b,3)+Math.pow(c,3))==i){
                System.out.println(i);
            }
        }
    }
 private static   List<Integer> list=new ArrayList<>();
public void Decomposition(int n) {
   StringBuffer sb=new StringBuffer();
   sb.append(n);
   sb.append("=");
   Solution s1 = new Solution();
    s1.de2(n);
    for(int x : list){
        sb.append(x);
        sb .append("+");
    }
}
    public int de2(int n){
        if(n==1){
            return 1;
        }
        int num=0;
        for(int i=2;i<=n;i++){
            if(n/i==0){
                if(n==i){
                    list.add(n);
                    return n;
                }
                list.add(i);
                num=n/i;
                break;
            }
        }
        return de2(num);
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        //System.out.println(s.Fibracci(5));
//        int[] arr=new int[100];
//        int num=100;
//        for(int i=0;i<100;i++){
//            arr[i]=num;
//            num++;
//        }
        //s.Prime();
       // s.count();
        s.Decomposition(90);
    }

}
