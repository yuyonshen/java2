package Test;

public class Solution {
//    public static void main(String[] args) {
//        String s=null;
//        System.out.println("s="+s);
//    }
//    String s=new String("good");
//    char[] a={'a','b','c'};
//
//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.chenge(solution.s,solution.a);
//        System.out.println(solution.s);
//        System.out.println(solution.a);
//    }
//    public void chenge(String s,char[] a){
//        a[0]='g';
//        s="task and";
//    }
public static void main(String[] args) {
    StringBuffer s1=new StringBuffer("a");
    StringBuffer s2=new StringBuffer("b");
    open(s1,s2);
    System.out.println(s1+"  "+s2);
}

    private static void open(StringBuffer s1, StringBuffer s2) {
    s1.append(s2);
    s2=s1;
    }
}
