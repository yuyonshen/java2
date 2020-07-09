import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            String s2 = sc.nextLine();
            s = s.toUpperCase();
            s2 = s2.toUpperCase();
            Set<Character> set = new HashSet<Character>();
            for (char x : s2.toCharArray()) {
                set.add(x);
            }
            List<Character> list = new ArrayList<Character>();
            for(char x : s.toCharArray()){
               if(!list.contains(x)){
                   list.add(x);
               }
            }
            for(char x : set){
                if(list.contains(x)){
                    for(int i=0;i<list.size();i++){
                        if(x==list.get(i)){
                            list.remove(i);
                        }
                    }
                }
            }
            String result = "";
            for (char x : list) {
                result += x;
            }
            System.out.println(result);
        }
    }
}
