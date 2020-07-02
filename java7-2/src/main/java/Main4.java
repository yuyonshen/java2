import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int count=0;
        for(int i=1;i<=n;i++){
        count+=helply(arr,i,0,sum);

        }
        System.out.println(count);
    }

    private static int helply(int[] arr, int num, int index, int sum) {
        int count=0;
        if(num==0){
            return sum==0?1:0;
        }
        for(int i=index;i<arr.length-num;i++){
            if(arr[i]<=sum){
                count+=helply(arr,num-1,index+1,sum-arr[i]);
            }
        }
        return count;
    }
}
