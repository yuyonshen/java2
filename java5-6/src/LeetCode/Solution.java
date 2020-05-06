package LeetCode;

import java.util.*;

public class Solution {
    //重述矩阵
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int add=0;
        int add1=0;
        int index=0;
        int[][] arr=new int[r][c];

            int length=nums.length;
            int length1=nums[0].length;
            int[][] arr1=new int[1][length*length1];
            if(r==1){
                for(int i=0;i<length;i++){
                    for(int j=0;j<length1;j++) {
                    arr1[0][index]=nums[i][j];
                    index++;
                    }

                    }
                return arr1;
            }
            for(int i=0;i<length;i++){
                for(int j=0;j<length1;j++){
                   index++;
                    if(index>c){
                        add++;
                        index=1;
                        add1=0;
                        arr[add][add1]=nums[i][j];
                        add1++;
                    }else{
                        arr[add][add1]=nums[i][j];
                        add1++;
                    }
                }
            }
            return arr;
    }
    public int[][] matrixReshape2(int[][] nums, int r, int c){
        int[][] ret=new int[r][c];
        if(nums.length==0||r*c!=nums.length*nums[0].length){
            return nums;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                queue.add(nums[i][j]);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ret[i][j]=queue.remove();
            }
        }
        return ret;
    }
    //独一无二的数
    public boolean uniqueOccurrences(int[] arr) {
       //首先使用HashMap来讲元素增加到集合中
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            Integer result=map.get(arr[i]);
            if(result==null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],result+1);
            }
        }
        //之后创建一个Set集合来判断时候有重复元素
        Set<Integer> set=new HashSet<>();
        for(int x : map.values()){
            if(!set.add(x)){
                return false;
            }
        }
        return true;
    }
}
