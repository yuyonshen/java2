package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
     //将ip的十进制转换为二进制,之后再转换为真个数的十进制
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String s2=sc.nextLine();
        //将十进制的ip转换一个整数
        heply(s);
        //将整数装换为十进制的ip
        helpy2(s2);

    }

    private static void helpy2(String s2) {
        String ip="";
        Long input=Long.parseLong(s2);
        for(int i=3;i>=0;i--){
            ip=input%256+"."+ip;
            input=input/256;
        }
        System.out.println(ip);
    }

    private static void heply(String s) {
        System.out.println(s);
        String[] str=s.split("\\.");
        System.out.println(Arrays.toString(str));
        StringBuffer sb=new StringBuffer();
      for(String x : str){
            String a=Integer.toBinaryString(Integer.parseInt(x));
            for(int i =0 ; i<8-a.length() ; i++){
                sb.append("0");
            }
            sb.append(Integer.toBinaryString(Integer.parseInt(x)));
        }
      //转换为十进制的整数
        System.out.println(Long.valueOf(sb.toString(),2).toString());
    }
}
