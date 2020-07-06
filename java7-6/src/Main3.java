import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       while(sc.hasNext()) {
           String s=sc.next();
           char[] n=s.toCharArray();
           int a=1;
           int j=7;
           int[] result=new int[8];
           while(j>=0){
                result[j]=(n[0]&a)==0?0:1;
                --j;
                a=a<<1;
           }
           System.out.println(Arrays.toString(result));
       }
    }
}
