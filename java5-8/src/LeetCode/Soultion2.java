package LeetCode;


import java.util.Scanner;

public class Soultion2 {
    public static void Calculator(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数字");
        int num1=scanner.nextInt();
        System.out.println("第一个整数:"+num1);
        int num2=scanner.nextInt();
        System.out.println("第二个整数:"+num2);
        System.out.println("请输入你的选择,0,表示加法,1,表示减法,2,表示乘法,3,标识号除法");
        int choose=scanner.nextInt();
        switch (choose){
            case 0:
                System.out.println(num1+num2);
                break;
            case 1:
                System.out.println(num1-num2);
                break;
            case 2:
                System.out.println(num1*num2);
            case 3:
                System.out.println((double)num1/num2);
        }

    }

    public static void main(String[] args) {
        Calculator();
    }
}

