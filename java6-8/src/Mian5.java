import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mian5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        List<Integer> list=new ArrayList<>();
        for(int x : arr) {
            list.add(x);
        }
        int index=-1;
        int num=0;
         while(!list.isEmpty()){
            if(index%(list.size())==list.size()){
                index=-1;
            }
            index=(index+1)%list.size();
            index=(index+1)%list.size();
            index=(index+1)%list.size();
            num=list.remove(index);
        }
        System.out.println(num-1);
    }
}
