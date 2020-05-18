package LeetCode;

import java.util.*;

public class Solution {
    //去除数组中的重复数字
    public static int[] DeWeight(int[] array){
        Set<Integer> set=new HashSet<>();
        for(int x : array){
            if(!set.contains(x)){
                set.add(x);
            }
        }
        int[] nums=new int[set.size()];
        int index=0;
        for( int x : set){
            nums[index]=x;
            index++;
        }
        return nums;
    }
    //使用递归算法反转字符串
    public static String Reverse(String s){

        if(s==null&&s.length()<=1){
            return s;
        }
        return Reverse(s.substring(1))+s.charAt(0);
    }
    //合并两个有序数组
    public static int[] Merge(int[] nums1,int[]nums2){
    int [] result=new int[nums1.length+nums2.length];
    int index=0;
    if(nums1.length==0){
        return nums2;
    }
    if(nums2.length==0){
        return nums1;
    }
    int i=0;
    int j=0;
    while(i<nums1.length&&j<nums2.length){
        if(nums1[i]<nums2[j]){
            result[index]=nums1[i];
            index++;
            i++;
        }else{
            result[index]=nums2[j];
            j++;
            index++;
        }
    }
    while(i<nums1.length){
        result[index]=nums1[i];
        i++;
        index++;
    }
    while(j< nums1.length){
        result[index]=nums2[j];
        j++;
        index++;
    }
    return result;
    }
    //找出三个有序数组中的共有的元素
    public static int Public(int[] num1,int[] num2,int[] num3){
        //使用HashMap来统计
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : num1){
            Integer ret=map.get(x);
            if(ret==null){
                map.put(x,1);
            }else{
                map.put(x,ret+1);
            }
        }
        for(int x : num2){
            Integer ret=map.get(x);
            if(ret==null){
                map.put(x,1);
            }else{
                map.put(x,ret+1);
            }
        }
        for(int x : num3){
            Integer ret=map.get(x);
            if(ret==null){
                map.put(x,1);
            }else{
                map.put(x,ret+1);
            }
        }
        for(int x : map.keySet()){
            if(map.get(x)==3){
                return x;
            }
        }
        return -1;
    }
    //从一个整数数组找出和为s的左右子集

    public static void main(String[] args) {
        int[] nums={1,2,5,7};
        int[] nums2={2,4,6,8};
        int[] nums3={2,5,7,9};
        System.out.println(Public(nums,nums2,nums3));

        //System.out.println(Arrays.toString(DeWeight(nums)));
    }
}
