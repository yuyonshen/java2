import java.util.*;
public class Main6{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] s=str.split(" ");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int[] a=new int[arr.length];
        for(int i=0;i<a.length;i++){
            a[i]=arr[i];
        }
        Arrays.sort(a);
        for(int i=0;i<arr[s.length-1];i++){
            if(i==arr[s.length-1]-1){
                System.out.print(a[i]);
            }else{
                System.out.print(a[i]+" ");
            }
        }
    }
}
