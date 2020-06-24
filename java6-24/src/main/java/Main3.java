import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
           int n=sc.nextInt();
           String[] arr=new String[n];
           for(int i=0;i<n;i++){
               arr[i]=sc.nextLine();
           }
           String str=sc.nextLine();
           boolean[] b=new boolean[n];
           for(int i=0;i<n;i++){
               if(str.contains(arr[i])){
                   b[i]=true;
               }
           }
            System.out.println(Arrays.toString(b));
        }
    }
}
