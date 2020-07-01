package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static String[] map = {"壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        helply(s);
    }

    private static void helply(String str) {
        String[] s=str.split("\\.");

        System.out.println(Arrays.toString(s));

        StringBuffer sb=new StringBuffer("人民币");
        int temp=Integer.valueOf(s[0]);
        int yi=(int)temp/100000000;
        if(yi!=0){
            sb.append(resolveQian(yi)).append("亿");
            temp=temp-yi*100000000;
        }
        int wan=temp/10000;
        if(wan!=0){
            sb.append(resolveQian(wan)).append("万");
            temp=temp-wan*10000;
        }
        //现在处理千百
        sb.append(resolveQian(temp)).append("元");

        //处理小数
        if(s.length>1){
            String s2=s[1];
            sb.append(helply2(s2));
        }
        System.out.println(sb.toString());
    }

    private static String helply2(String s2) {
        String res="";
        if(s2=="00"||s2=="0"){
            res="整";
        }else{
            if(s2.charAt(0)!='0'){
                res+=map[Integer.valueOf(s2.charAt(0)+"")-1]+"角";
            }
            if(s2.length()>1&&s2.charAt(1)!=0){
                res+=map[Integer.valueOf(s2.charAt(1)+"")-1]+"分";
            }
        }
        return res;
    }

    private static String resolveQian(double temp) {
        StringBuffer sb=new StringBuffer();
        int qian=(int)temp/1000;
        if(qian!=0){
            sb.append(map[qian-1]).append("仟");
            temp=temp-qian*1000;
        }
        int bai=(int)temp/100;
        if(bai!=0){
            sb.append(map[bai-1]).append("佰");
            temp=temp-bai*100;
        }
        if(qian!=0&&bai==0){
            sb.append("零");
        }
        int shi=(int)temp/10;
        if(shi!=0){
            if(shi!=1){
                sb.append(map[shi-1]);
            }
            sb.append("拾");
            temp=(int)temp%10;
        }
        if(bai!=0&&shi==0){
            sb.append("零");
        }
        int ge=(int)temp%10;
        if(ge!=0){
            if(qian==0&&bai==0&&shi==0){
                sb.append("零");
            }
            sb.append(map[ge-1]);

        }

        String s1=sb.toString();
        return s1;
    }
}
