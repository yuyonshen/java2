import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String addend=sc.nextLine();
        String augend=sc.nextLine();
        Main m=new Main();
        m.AddLonginteger(addend,augend);

    }
    public  String AddLonginteger(String addend,String augend){
        long a=Integer.parseInt(addend);
        long b=Integer.parseInt(augend);
        long c=a+b;
        String str=String.valueOf(c);
        return str;
    }
}
