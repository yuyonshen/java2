
import java.util.*;

public class Main2 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//       List<Integer> list=new ArrayList<>();
//       while(sc.hasNextInt()){
//           list.add(sc.nextInt());
//       }
//       int num=0;
//        int max=0;
//       for(int i=0;i<list.size();i++){
//           int index=0;
//           for(int j=i+1;j<list.size();j++){
//                if(list.get(i).equals(list.get(j))){
//                    index++;
//                }
//            }
//           if(index<max){
//               num=i;
//               max=Math.max(index,max);
//
//           }
//
//        }
//        System.out.println(list.get(num));
//    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    String[] a=str.split(" ");
    int[] arr=new int[a.length];
    for(int i=0;i<a.length;i++){
        arr[i]=Integer.parseInt(a[i]);
    }
    Map<Integer ,Integer> map=new HashMap<>();
    for(int x : arr){
       map.put(x,map.getOrDefault(x,0)+1);
    }
    Integer len=arr.length/2;
    int ret = 0;
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        if(entry.getValue()>=(arr.length/2)){
            ret=entry.getKey();
        }
    }
   System.out.println(ret);
}
}
