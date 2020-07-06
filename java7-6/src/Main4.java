import java.util.*;
public class Main4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] s2=s.split(" ");
        String[] str=s2[0].split("\\.");
        String[] str2=s2[1].split("\\.");
        int[] arr1=new int[3];
        int[] arr2=new int[3];
        for(int i=0;i<3;i++){
            arr1[i]=Integer.parseInt(str[i]);
        }
        for(int i=0;i<3;i++){
            arr2[i]=Integer.parseInt(str2[i]);
        }
        int a=0;
        int b=0;
        int c=0;

        if(arr2[2]-arr1[2]>0){
            c=arr2[2]-arr1[2];
        }else{
            arr2[1]=arr2[1]-1;
            c=arr2[2]+19-arr1[2];
        }
        if(arr2[1]-arr1[1]>0){
            b=arr2[1]-arr1[1];
        }else{
            arr2[0]=arr2[0]-1;
            b=arr2[1]+17-arr1[1];
        }
        a=arr2[0]-arr1[0];
        System.out.println(a+"."+b+"."+c);
    }
}