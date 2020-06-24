import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            char[] arr=str.toCharArray();
            for(int i=0;i<arr.length;i++){
                char a=arr[i];
                if(a>'A'){
                    a=(char)(a>'E'?a-5:a+21);
                    arr[i]=a;
                }
            }
            System.out.println(new String(arr));
        }
    }
}
