package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    //找出t中s没有的一个字母
    public char findTheDifference(String s, String t) {
       Map<Character,Integer> map= new HashMap<>();
        for(char x : s.toCharArray()){
            Integer count=map.get(x);
            if(count==null){
                map.put(x,1);
            }else{
                map.put(x,count+1);
            }
        }
        for(char x : t.toCharArray()) {
            Integer num=map.get(x);
            if(num==null){
                return x;
            }else{
                if(num-1==0){
                    map.remove(x);
                }else{
                    map.put(x,num-1);
                }
            }
        }
        return 0;
    }
    //给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
    // 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

    public boolean containsNearbyDuplicate(int[] nums, int k) {
      for(int i=0;i<nums.length;i++){
          for(int j=i+1;j<nums.length;j++) {
            if(nums[i]==nums[j]){
                if((j-i)<=k){
                    return true;
                }else{
                    continue;
                }
            }
          }
      }
      return false;
    }
    //给定一个整数数组判断是否有重复数字
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int x : nums){
            if(set.contains(x)){
                return true;
            }else{
                set.add(x);
            }
        }
        return false;
    }
    //出现单词次数最多的
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer>map=new HashMap<>();
        for()
    }
}
