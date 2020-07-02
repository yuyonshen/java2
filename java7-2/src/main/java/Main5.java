import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=helply(n);
            int z=helply2(n);
        }
    }

    private static int helply2(int n) {
        
    }

    private static int helply(int n) {
        int result=1;
        if(n==0){
            return 1;
        }else if(n>0){
            result=n*helply(n-1);
        }
        return result;
    }
}
