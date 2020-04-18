package ListLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //二维网格的迁移
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for(;k>=0;k--){
            int[][] newgrid=new int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length-1;j++){
                    newgrid[i][j+1]=grid[i][j];
                }
            }
            for(int i=0;i<grid.length-1;i++){
                newgrid[i+1][0]=grid[i][grid[0].length-1];
            }
            newgrid[0][0]=grid[grid.length-1][grid[0].length-1];
            grid=newgrid;
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int[] x: grid){
            List<Integer> list=new ArrayList<>();
            result.add(list);
            for(int a : x){
                list.add(a);
            }
        }
        return result;
    }
    //法官小镇
    public int findJudge(int N, int[][] trust){
        List<Integer> A=new LinkedList<>();
        List<Integer> B=new LinkedList<>();
        for(int i=0;i<N;i++){
            A.add(trust[i][0]);
            B.add(trust[i][1]);
        }
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                if(A.get(i)==B.get(j)){
                    B.remove(j);
                }
            }
        }
        if(B.isEmpty()){
            return -1;
        }
        for(int i=0;i<B.size();i++){
            if(B.get(0)!=B.get(i)){
                return -1;
            }
        }
        return B.get(0);
    }
    //数组分为相等的三部分
    public boolean canThreePartsEqualSum(int[] A){
        int num=0;
        for(int i=0;i<A.length;i++){
            num+=A[i];
        }
        if(num%3!=0){
            return false;
        }
        int left=0;
        int right=A.length-1;
        int index=num/3;
        int a=0;
        int b=0;
        while(right-left>=1){
            while(right-left>=1){
                a+=A[left];
                left++;
                if(a==index){
                    break;
                }
            }
            while(right-left>=1){
                b+=A[right];
                right--;
                if(b==a){
                    return true;
                };
            }
        }
        return false;
    }
    //找出水柱面积最大的
    public int maxArea(int[] height){
        int weigth=0;
        int hight=0;
        int add=0;
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                if(height[i]>height[j]){
                    hight=height[j];
                }else{
                    hight=height[i];
                }
                weigth=j-i;
                add=hight*weigth;
                max=Math.max(max,add);
            }
        }
        return max;
    }
}
