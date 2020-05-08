package LeetCode;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


    private static int AnnualSalary(int month,int time){
        int add=0;
        if(time<170){
            add=time*50;
        }else{
            add=(time-170)*65+170*50;
        }
        if(month==1||month==2){
            add=2*add;
        }
        return add;
    }
    //给定过一个字符串，找到它的第一个不重复的字符串，并放回它的引索，如果不存在则返回-1.
    public static int  first(String s){
        Map<Character,Integer> map=new HashMap<>();
        for(char x : s.toCharArray()){
            Integer ret=map.get(x);
            if(ret==null){
                map.put(x,1);
            }else{
                map.put(x,ret+1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    //定义一个int类型的变脸接收一个大于100的三位数,球池100到该数之间满足一下要求
    //1.数字的个位数不为8.
    //2.数字的十位数不为6,
    //3.数字的百位数不为5.
    public static int findnum(){
        int result=0;
        for(int i=100;i<1000;i++){

            int a=i;
            if(a%10!=8 && a/10%10!=6 && i/100!=5){
                result+=a;
            }else{
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入工作时间");
        int reslut=0;
        for(int i=1;i<=12;i++){
            int month=i;
            int time=scanner.nextInt();
            reslut+=AnnualSalary(month,time);
        }
        System.out.println(reslut);

    }

}
