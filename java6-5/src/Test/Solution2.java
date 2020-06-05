package Test;

import java.util.Stack;

public class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
       Integer re=null;
        if(!stack2.empty()){
           re=stack2.pop();
       }else{
            while(!stack1.empty()){
                re=stack1.pop();
                stack2.push(re);
            }
            if(!stack2.empty()){
                re=stack2.pop();
            }
        }
        return re;
    }
}