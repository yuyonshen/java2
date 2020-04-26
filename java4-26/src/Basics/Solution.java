package Basics;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    Scanner scanner =new Scanner(System.in);
        System.out.println("请输入年份");
        int year=scanner.nextInt();
        if((year%4==0)&&(year%100!=0)||(year%400==0)){
            System.out.println("闰年");
        }else{
            System.out.println("不是闰年");
        }

    }
    public static void add() {
        int size=0;
        for (int i = 1; i <= 10; i++){
            int num=Factorial(i);
            size=size+num;
        }
        System.out.println(size);
    }

    private static int Factorial(int a) {
        if(a==1){
            return 1;
        }
        if(a==2){
            return 2;
        }
        return a*Factorial(a-1);
    }
    public void Opposite(){
        int[] array={100,101,102,103,104,105};
        int left=0;
        int right=array.length-1;
        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;

            left++;
            right--;
        }
        System.out.println(Arrays.toString(array));
    }
    public void Rabbit(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入月: ");
        int num=Fibonacci(scanner.nextInt());
        System.out.println(num);
    }

    private int Fibonacci(int n) {
        if(n<=3){
            return 2;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
