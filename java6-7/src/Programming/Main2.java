package Programming;

import java.util.Stack;

public class Main2 {
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    static Stack<Integer> a1=new Stack<>();
    static Stack<Integer> a2=new Stack<>();

        public void push(int node){
            a1.push(node);
        }
        public int Pop(){
            if(a1.empty()&&a2.empty()){
                throw  new RuntimeException("Queue is empty");
            }
            if(a2.empty()){
                while(!a1.empty()){
                    a2.push(a1.pop());
                }
            }
            return a2.pop();
        }

}
