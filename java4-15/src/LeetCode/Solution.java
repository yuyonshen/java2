package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //给定一个升序数组,在给到你一个目标值,找出目标值的其实位置和结束位置
    public int[] searchRange(int[] nums, int target) {
//        int left=0;
//        int right=nums.length-1;
//        while(left<=right){
//            while(nums[left]<target){
//                left++;
//        }
//            while(nums[right]>target){
//                right--;
//            }
//
//    }
//        if(nums[left]==nums[right]&&nums[left]==nums[target]){
//            return new int[]{left,right};
//        }
//        return new int[]{-1,-1};
        int[] arr={-1,-1};
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                arr[0]=i;
                break;
            }

        }
        if(arr[0]==-1){
            return arr;
        }
        for(int j=nums.length-1;j>=0;j--){
            if(target==nums[j]){
                arr[1]=j;
                break;
            }
        }
        return arr;
    }
    //判断这个字符串是否为回文字符串,不区分大小写,包括数字,不包括符号,空格
    public boolean isPalindrome(String s) {
        s=s.trim();
        String sb=s.toUpperCase();
        int num=0;
       StringBuffer sba=new StringBuffer();
        for(char x : sb.toCharArray()){
            if(Character.isLetterOrDigit(x)){
                sba.append(x);
                //num++;
            }
        }
        int left=0;
        int right=sba.length()-1;
        while(left<=right){
            if((sba.charAt(left))!=(sba.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    //给定一个数组在这个数组之熬出一个子数组,这个子数组可以升序排列
    public int findUnsortedSubarray(int[] nums) {
        int[] array = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            array[i]=nums[i];
        }
        Arrays.sort(array);
        int left = 0;
        int right = nums.length - 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==array[i]){
                left++;
            }else{
                break;
            }
        }
        for(int j=nums.length-1;j>=left;j--){
            if(nums[j]==array[j]){
                right--;
            }else{
                break;
            }
        }
        return right-left+1;
    }

    public static void main(String[] args) {
        Solution sa=new Solution();
        String s="aba";
        boolean haah=sa.isPalindrome(s);
        System.out.println(haah);
    }
}
