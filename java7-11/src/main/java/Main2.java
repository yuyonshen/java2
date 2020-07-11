import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        s=s.substring(2);
        int result=0;
        int a=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='F'){
                result+=15*Math.pow(16,a);
                a++;
            }else if(s.charAt(i)=='E'){
                result+=14*Math.pow(16,a);
                a++;
            }else if(s.charAt(i)=='D'){
                result+=13*Math.pow(16,a);
                a++;
            }else if(s.charAt(i)=='C'){
                result+=12*Math.pow(16,a);
                a++;
            }else if(s.charAt(i)=='B'){
                result+=11*Math.pow(16,a);
                a++;
            }else if(s.charAt(i)=='A'){
                result+=10*Math.pow(16,a);
                a++;
            }else {

                result+=Integer.parseInt(String.valueOf(s.charAt(i)))*Math.pow(16,a);
                a++;
            }

        }
        System.out.println(String.valueOf(result));
    }
}