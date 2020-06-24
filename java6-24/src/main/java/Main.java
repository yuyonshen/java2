import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        int num=getTotalCount(month);
        System.out.println(num);
    }
    public static int getTotalCount(int n){
        if(n==1||n==2){
            return 1;
        }
        return getTotalCount(n-1)+getTotalCount(n-2);

    }
}