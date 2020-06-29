import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            helply(n);
        }
    }
    public static void helply(int n){
        int index=0;
        int num=n;
        while(num>0){
            index+=num%10;
            num=num/10;
        }
        int a= (int) Math.pow(n,2);
        int index2=0;
        while(a>0){
            index2+=a%10;
            a=a/10;
        }
        System.out.println(index+" "+index2);
    }
}
