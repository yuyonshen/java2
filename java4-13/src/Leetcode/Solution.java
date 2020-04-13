package Leetcode;


import sun.awt.geom.AreaOp;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //给定一个非递减的数组,数组中的每个元素平方后,也是一个非递减的数组
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i]= (int) Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }



    //翻转字符串,如果不是字母的字符保留原地
    public String reverseOnlyLetters(String S) {
        //首先创建一个栈
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if(Character.isLetter(c)){
                stack.push(c);
            }
        }
        StringBuffer sb=new StringBuffer();
        for(char c:S.toCharArray()){
            if(Character.isLetter(c)){

                sb.append(stack.pop());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //给定一个非负整数数组,放回其偶数在前奇数在所有偶数之后
    public static int[] sortArrayByParity(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<right){
            if(left<right&&A[left]%2==0){
                left++;
            }if(left<right&&A[right]%2!=0){
                right--;
            } else {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
       return A;
    }
    //给定一个数组,找出数组的中心引锁
    //中心引锁的左边数据相加等于数组右侧数据相加.如果找了放回中心引锁的位置没有找到返回-1;
    public static  int pivotIndex(int[] nums) {
//        int left=1;
//        int right=nums.length-1;
//        int leftnum=0;
//        int rightnum=0;
//        while(left<right){
//            for(int i=0;i<left;i++){
//                leftnum+=nums[i];
//            }
//            for(int j=left+1;j<=right;j++){
//                rightnum+=nums[j];
//            }
//            if(leftnum==rightnum){
//                return left;
//            }
//            left++;
//            leftnum=0;
//            rightnum=0;
//        }
//        return -1;
        int leftnum=0;
        int num=0;
        for(int x:nums){
            num+=x;
        }
        for(int i=0;i<nums.length;i++){
            if(leftnum==(num-leftnum-nums[i])){
                    return i;
            }else{
                leftnum+=nums[i];
            }

        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums={-1,-1,0,1,1,0};
        int a=pivotIndex(nums);
        System.out.println(a);
    }
}
