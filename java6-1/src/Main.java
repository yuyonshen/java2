import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(add(n));
        }
    }
    public static int add(int n){
        if(n<2){
            return 0;
        }
       int reslut=0;
        int index=n;
        int a=0;
        int b=0;
        while(index>=2){
            if(index==2){
                 index++;
            }else {
                b = index / 3;
                reslut += b;
                a = index % 3;
                index = index / 3;
                index = index + a;
            }

        }
        return reslut;
    }
}
