package LeetCode;

import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    //括号问题
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.empty()){
                    return false;
                }
                if(stack.peek()=='('&& s.charAt(i)==')'){
                    stack.pop();
                }else if(stack.peek()=='{'&& s.charAt(i)=='}'){
                    stack.pop();
                }else if(stack.peek()=='['&& s.charAt(i)==']'){
                    stack.pop();
                }else{
                    return false    ;
                }
            }
        }
        if(stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {


        PriorityQueue<Integer> pr = new PriorityQueue<>();
        pr.offer(2);
        pr.offer(10);
        pr.offer(0);
        pr.offer(23);
        pr.offer(12);

        while (!pr.isEmpty()) {
            System.out.println(pr.poll());
        }
    }

}
