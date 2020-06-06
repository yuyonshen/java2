import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[4];
        for(int i=0;i<4;i++){
            arr[i]=sc.nextInt();
        }
        int[] result=new int[3];
        result[0]=(arr[0]+arr[2])/2;
        result[1]=(arr[1]+arr[3])/2;
        if(((arr[3]-result[1])==(result[1]-arr[1]))){
            result[2]=arr[3]-result[1];
            if(result[0]<0||result[1]<0||result[2]<0) {
                System.out.println("No");
                return;
            }
            System.out.print(result[0]+" ");
            System.out.print(result[1]+" ");
            System.out.print(result[2]);
        } else{
            System.out.println("No");
        }
    }
}
