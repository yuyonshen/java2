import java.lang.reflect.Array;
import java.util.*;
public class Mian2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        List<Integer> list2=new ArrayList<>();
        for(int x :b){
            list2.add(x);
        }
        List<List<Integer>> list=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<list2.size();j++){
                if(a[i]==list2.get(j)){
                    List<Integer> result=new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    list.add(result);
                    list2.remove(j);
                    index++;
                    break;
                }
            }
        }
        if(index==a.length){
            System.out.println(index-1);
        }else {
            System.out.println(index + 1);
        }
    }
}
