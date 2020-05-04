package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    //给定一个数组,找到一个具有最大和的子数组中
    public static int max(int[] array){
        //首先判断这个数组中是否只有一个元素
        if(array.length==1){
            return array[1];
        }
        int max=array[0];
        int add=0;
        int a=0;
        for(int i=0;i<array.length;i++){
            a=array[i];
            for(int j=i;j<array.length;j++){
                 add+=array[j];
                if(max<add){
                    max=add;
                }
            }

            add=0;
        }
        return max;
    }

    public int max2(int array[]){
        int result=array[0];
        int add=0;
        for(int nums : array){
            if(add>0){
                add+=nums;
            }else{
                add=nums;
            }
            result=Math.max(result,add);
        }
        return result;
    }
    //单值二叉树
    public boolean isUnivalTree(TreeNode root) {
        //需要循环遍历这个二叉树
        double result=root.val;
        if(root.left==null&&root.right==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.val!=result){
                return false;
            }
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
        return true;
    }

    //环绕字符串的唯一字符串
    public static int findSubstringInWraproundString(String p) {
        int len = p.length();
        if (len == 0) {
            return 0;
        }
        int[] map = new int[26];
        int dp = 0;
        int sum = 0;
        char[] arr = p.toCharArray();
        for (int i=0; i<len; i++) {
            char c = arr[i];
            if (i == 0 || (c-arr[i-1] -1)%26 == 0) {
                dp++;
            } else dp = 1;
            int cnt = map[c-'a'];
            if (dp > cnt) {
                sum += dp - cnt;
                map[c-'a'] = dp;
            }
        }
        return sum;
    }
    //给定一个32位整数 num，你可以将一个数位从0变为1。
    // 请编写一个程序，找出你能够获得的最长的一串1的长度。
    public int reverseBits(int num) {
        int a=num;
        int dp=0;
        int result=0;
        if(a==0){
            return 1;
        }
        while(a!=0){
            if(a%10==1||a%10==0){
                dp++;
            }else{
                dp=0;
            }
            a=a/10;
            result=Math.max(result,dp);
        }
        return result;
    }
    public static void main(String[] args) {
//        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(max(arr));
        String q="zab";
        Solution s=new Solution();
       int result= s.reverseBits( 70111);
        System.out.println(result);
    }
}
