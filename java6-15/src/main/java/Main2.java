import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int a= (int) Math.pow(m,2);
        if(m%2!=0){
            int b=a;
            for(int i=0;i<m/2;i++){
                b-=2;
            }
            String str=OddNum(m,b);
            String[] s=str.split(" ");
            for(int i=0;i<s.length;i++){
                if(i==s.length-1){
                    System.out.print(Integer.parseInt(s[i]));
                }else{
                    System.out.print(Integer.parseInt(s[i])+"+");
                }
            }
        }else{
            int c=a;
            c--;
            for(int i=1;i<m/2;i++){
                c-=2;
            }
            String str1=OddNum(m,c);
            String[] s1=str1.split(" ");
            for(int j=0;j<s1.length;j++){
                if(j==s1.length-1){
                    System.out.print(Integer.parseInt(s1[j]));
                }else{
                    System.out.print(Integer.parseInt(s1[j])+"+");
                }
            }
        }

    }

    private static String OddNum(int m, int b) {
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=m;i++){
            if(i==m){
                sb.append(b);
            }else{
                sb.append(b+" ");
                b+=2;
            }
        }
        return sb.toString();
    }
}
