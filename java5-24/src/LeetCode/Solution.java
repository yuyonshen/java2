package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //利用运算符的嵌套来完成此题:
    public int Operator(int a ,int b,int c) {
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (c < b) {
                return b;
            } else {
                if (b > c) {
                    return c;
                }
            }
            return -1;
        }

    }
    //最大公约数
    public void big(int m,int n) {
        if (m > n) {
            for (int i = n; i < 0; i--) {
                if (m % i == 0 && n % i == 0) {
                    System.out.println("最大公约数:" + i);
                    break;
                }
            }

        } else {
            for (int i = m; i < 0; i--) {
                if (m % i == 0 && n % i == 0) {
                    System.out.println("最大公约数:" + i);
                    break;
                }
            }
        }
    }
    //最小公倍数
    public void small(int m,int n){
        if(m>n){
            for(int i=2;i<=n;i++){
                if(m%i==0&&n%i==0){
                    System.out.println("最小公倍数"+i);
                    break;
                }
            }
        }else{
            for(int i=2;i<=m;i++){
                if(m%i==0&&n%i==0){
                    System.out.println("最小公倍数"+i);
                    break;
                }
            }
        }
    }
    public void stringtest(String s){
        int a=0;
        int b=0;
        int c=0;
        int d=0;

        for(char x : s.toCharArray()) {
            if (Character.isLetter(x)) {
                a++;
            }
            if (x-'0'>=0&&x-'0'<10){
                b++;
            }
            if(" ".equals(x)){
                c++;
            }else{
                d++;
            }
        }
        System.out.println("字母的个数:"+a);
        System.out.println("数字的个数:"+b);
        System.out.println("空格的个数:"+c);
        System.out.println("其余的个数:"+d);
    }
    public void Accumulation(int num,int times ){
        int reslut=0;
        int add=num;
        if(num==0){
            System.out.println(0);
        }
        for(int i=0;i<times;i++){
            reslut+=add;
            add=add*10+num;
        }
        System.out.println(reslut);
    }
    //一个数如果恰好等于它的因子之和,这个数就称为"完数.找出一千以内的完整数
    public void Factor(){
        int reslut=0;
        for(int i=1;i<=1000;i++){
            for(int j=1;j<=i/2+1;j++){
                if(i%j==0){
                    reslut+=j;
                }
            }
            if(reslut==i){
                System.out.println(i);
            }
            reslut=0;
        }
    }
    public double heigth( double h,double n){
        if(h==0){
            return 0;
        }
        if(n==0){
           return h;
        }
        return heigth(h/2,n-1);
    }
    List<Integer> list=new ArrayList<>();
    public List<Integer> Decomposition(int n){
        int num=0;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                num=n/i;
                list.add(i);
                if(n==i){
                    return list;
                }
                break;
            }
        }

        return Decomposition(num);
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        //s.Factor();
        //System.out.println( s.heigth(90,5));
        System.out.println(s.Decomposition(80));
    }
}
