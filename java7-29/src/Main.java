import java.util.Scanner;
/**
 * 给定一个仅由小写字母组成的字符串。现在请找出一个位置，删掉那个字母之后，字符串变成回文。
 * 请放心总会有一个合法的解。如果给定的字符串已经是一个回文串，那么输出-1。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            StringBuffer s = new StringBuffer(sc.nextLine());
            int[] start = new int[1];
            int[] end = new int[1];
            if(helply(s, start, end)){
                System.out.println(-1);
            }else{
                s.deleteCharAt(start[0]);
                if(helply(s,null,null)){
                    System.out.println(start[0]);
                }else{
                    System.out.println(end[0]);
                }
            }
        }
    }

    private static boolean helply(StringBuffer s, int[] start, int[] end) {
        int i = 0;
        int j = s.length()-1;
        boolean reslut = true;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
              reslut = false;
                break;
            }
            i++;
            j--;

        }
        if(start != null){
            start[0] = i;
        }
        if(end != null){
            end[0] = j;
        }
        return reslut;


    }
}
