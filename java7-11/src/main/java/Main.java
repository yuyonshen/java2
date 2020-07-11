import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            Map<Character,Integer> map = new HashMap<Character, Integer>();
            char a='A';
            while(a<='Z'){
                map.put(a,0);
                a++;
            }
            System.out.println(map);
            for(char x : s.toCharArray()){
                if(map.get(x)!=null){
                    map.put(x,map.get(x)+1);
                }
            }
           for(Map.Entry<Character,Integer>entry : map.entrySet()){
               System.out.println(entry.getKey()+":"+entry.getValue());
           }
        }
    }
}
