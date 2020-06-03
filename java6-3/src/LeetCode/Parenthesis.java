package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Queue<Character> queue1=new LinkedList<>();
       for(int i=0;i<n;i++){
           if(A.charAt(i)!='('&&A.charAt(i)!=')'){
               return false;
           }else if(A.charAt(i)=='('){
               queue1.offer(A.charAt(i));
           }else{
               queue1.poll();
           }

       }
       if(queue1.isEmpty()){
           return true;
       }
       return false;
    }
}
