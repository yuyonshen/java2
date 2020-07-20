import java.util.*;
public class Main4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] str = s.split("_");
            StringBuffer sb = new StringBuffer();
            sb.append(str[0]);
            for(int i=1;i<str.length;i++){
                String s2 = str[i].substring(0,1).toUpperCase()+str[i].substring(1);
                sb.append(s2);
            }
            System.out.println(sb.toString());
        }
    }
}
