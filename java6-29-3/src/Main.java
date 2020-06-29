import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int A1=0,A2=0,A3=0,A4=0,A5=0;
        int num=0;
        int flag=1;
        for(int i=0;i<n;i++){
            if(arr[i]%5==0&&arr[i]%2==0){
                A1+=arr[i];
            }else if(arr[i]%5==1){
                A2+=flag*arr[i];
                flag=-flag;
            }else if(arr[i]%5==2){
                A3++;
            }else if(arr[i]%5==3){
                A4+=arr[i];
                num++;

            }else if(arr[i]%5==4){
                A5=Math.max(A5,arr[i]);
            }
        }
        System.out.print(A1+" "+A2+" "+A3);
        System.out.printf("%f", A4/num+" ");
        System.out.print(A5);
    }
}
