package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //将这个数组中的袁术组成一个整数,之后再这个整数的后面字后以为加上1
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    //给定一个费控数组,楸树数组的中的第三大数字,如果没有第三大数字返回最大数字
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int[] arr = new int[set.size()];
        int a = 0;
        for (int x : set) {
            arr[a] = x;
            a++;
        }
        Arrays.sort(arr);
        if (arr.length < 3) {
            return arr[arr.length - 1];
        }
            return arr[arr.length - 3];


    }
    //给定一个数组,和一个指定的值,找出数组中的两个数相加的和为指定的值,返回连个数的下标
    public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                  return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //在字符川中找到整数
    public int myAtoi(String str) {

    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={1,2,3};

        System.out.println(s.thirdMax(arr));
    }
}
