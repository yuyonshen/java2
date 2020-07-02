import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int num=(int)Math.pow(n,2);
            int index=0,index2=0;
            while(n>0){
                index=index+n%10;
                n=n/10;
            }
            System.out.print(index+" ");
            while(num>0){
                index2=index2+num%10;
                num=num/10;
            }
            System.out.println(index2);
        }
    }
}
