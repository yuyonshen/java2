import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        //int T=sc.nextInt();
       for(int i=0;i<T;i++){
         String s=sc.nextLine();
         boolean flag=true;
         for(int j=0, k=s.length()-1;j<=s.length()/2;j++,k--) {
             if (s.charAt(j) != s.charAt(k)) {
                 if (s.charAt(j + 1) == s.charAt(k)) {
                     System.out.println(j);
                     flag=false;
                     break;
                 } else if (s.charAt(j) == s.charAt(k - 1)) {
                     System.out.println(k);
                     flag=false;
                     break;
                 }
             }
         }
         if(flag==true){
             System.out.println(-1);
         }
       }

    }
}
