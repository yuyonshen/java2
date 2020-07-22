import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while( sc.hasNext()){
            String s = sc.nextLine();
            String[] str = s.split(" ");
            String A = str[0];
            String B = str[1];

            HashMap<Character, Integer> map = new HashMap<>();

            for(char x : A.toCharArray()){
                map.put(x ,map.getOrDefault(x,0)+1);
            }
            int nums = 0;
            System.out.println(map);
            for(int i=0; i < B.length(); i++){
                if(map.get(B.charAt(i)) == null || map.get(B.charAt(i)) == 0){
                    nums++;
                }else {
                    int result = map.get(B.charAt(i));
                    map.put(B.charAt(i), result - 1);
                }
            }
            if(nums > 0){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
