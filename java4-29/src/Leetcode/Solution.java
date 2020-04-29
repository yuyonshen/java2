package Leetcode;

import java.util.Stack;

public class Solution {
    //翻转单词的顺序
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            if(!arr[i].equals("")){
                sb.append(arr[i]+" ");
            }
        }
        return sb.toString().trim();
//        Stack<String> stack=new Stack<>();
//        for(String x : arr){
//            stack.push(x);
//        }
//        while(!stack.isEmpty()){
//            String a=stack.pop();
//            sb.append(a+" ");
//        }
//        return sb.toString().trim();
    }
}
