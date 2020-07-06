import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            helply(s);
        }

    }

    private static void helply(String s) {
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            int a=arr[i]-0;
            String str=Integer.toBinaryString(a);
            StringBuffer sb=new StringBuffer();

            for(int j=0;j<8-str.length();j++){
                sb.append("0");
            }
            sb.append(str);
            int nums=0;
            for(int z=0;z<sb.length();z++){
                if(sb.charAt(z)=='1'){
                    nums++;
                }
            }
            if(nums%2==0) {
                sb.setCharAt(0,'1');
                System.out.println(sb.toString());
            }else{
                System.out.println(sb.toString());
            }
        }
    }
}
