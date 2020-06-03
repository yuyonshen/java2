package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.nextLine();
        String B=sc.nextLine();
        List<Character> list=new LinkedList<>();
        for(int i=0;i<A.length();i++){
            list.add(A.charAt(i));
        }
        for(int i=0;i<B.length();i++){
            for(int j=0;j<list.size();j++){
                if(B.charAt(i)==list.get(j)){
                    list.remove(j);
                }
            }
        }
        StringBuffer str=new StringBuffer();
        for(char x : list){
            str.append(x);
        }
        System.out.println(str.toString());
    }
}
