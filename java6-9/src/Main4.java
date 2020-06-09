import java.util.*;
public class Main4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < T; ++i){
            String s = sc.nextLine();
            boolean flag = true;//判断原字符串是否是回文
            for(int j = 0, k = s.length() - 1; j <= s.length()/2; ++j, --k){
                if(s.charAt(j) != s.charAt(k)){
                    if(s.charAt(j + 1) == s.charAt(k)){//不多余的那个必与下一个相等
                        System.out.println(j);
                        flag = false;
                        break;
                    }else if(s.charAt(j) == s.charAt(k - 1)){
                        System.out.println(k);
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) System.out.println(-1);//是回文就打印-1
        }
    }
}
