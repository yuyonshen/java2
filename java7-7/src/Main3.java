import java.util.Scanner;
public class Main3 {
    /*public int countWays(int n) {
        // write code here
        if(n<0){
            return 0;
        }else if(n==0){
            return 1;
        }else{
            return countWays(n-1)+countWays(n-2)+countWays(n-3);//递归
        }
    }*/
    //结果出来挺快的
    public int countWays(int n) {
        int n1=1;
        int n2=2;
        int n3=4;
        int sum=0;
        if(n<3){
            return n;
        }
        if(n==3){
            return n3;
        }
        for(int i=4;i<=n;i++){
            sum=((n1+n2)%1000000007+n3)%1000000007;
            n1=n2;
            n2=n3;
            n3=sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Main3 m=new Main3();
        System.out.println(m.countWays(n));
    }
}

