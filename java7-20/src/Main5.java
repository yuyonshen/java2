import java.util.*;
public class Main5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String s = sc.nextLine();
        String[] str = s.split(" ");
        for(String x : str){
            if(x.length() == 0){
                continue;
            }
            stack.push(x);
        }
        StringBuffer sb = new StringBuffer();
        while( !stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb.toString());
    }
}