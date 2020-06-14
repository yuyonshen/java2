import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String c=sc.next();
        for(int i=1;i<=N;i++){
            System.out.print(c);
        }
        System.out.println();
        for(int i=1;i<=Math.ceil((double)N/2)-2;i++){
            System.out.print(c);
            for(int j=2;j<=N-1;j++){
                System.out.print(" ");
            }
            System.out.println(c);
        }
        for(int i=1;i<=N;i++){
            System.out.print(c);
        }
    }
}
