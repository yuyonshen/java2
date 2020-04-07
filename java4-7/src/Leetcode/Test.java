package Leetcode;


import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test {
    //二叉树的层次遍历
    List<List<Integer>> result=new ArrayList<>();
    List<List<Integer>> result2=new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null){
            return result;
        }
        helper(root,0);
        Stack<List> stack=new Stack<>();
        for(int i=0;i<result.size();i++){
            stack.push(result.get(i));
        }
        while(!stack.isEmpty()){
            result2.add(stack.pop());
        }
        return result2;
    }
    Queue<TreeNode> queue=new LinkedList<>();
    private void helper(TreeNode root, int i) {
        queue.offer(root);
        while(!queue.isEmpty()) {
            if (result.size() == i) {
                result.add(new ArrayList());
            }
            TreeNode cur=queue.poll();
            result.get(i).add(cur.val);

            if(cur.left!=null){
                helper(cur.left,i+1);
            }
            if(cur.right!=null){
                helper(cur.right,i+1);
            }
        }

    }
//旋转矩阵
    //将一个二维数组旋转90度得到的新二维数组
    public void rotate(int[][] matrix) {
        int length=matrix[0].length;
        int high=matrix.length;
        int[][] arr=new int[high][length];
       int index=0;
       //int j=0;
       for(int i=0;i<high;i++){
           for(int j=0;j<length;j++){
               arr[i][j]=matrix[i][j];
           }
       }
//       while(index<length){
//           for(int i=0;i<length;i++){
//               arr[j][length-1]=matrix[index][i];
//               j++;
//               index++;
//           }
//       }

       int o=length-1;
       while(index<length){
           int z=0;
           for(int i=0;i<length;i++){
                matrix[z][o]=arr[index][i];
                z++;

            }
            index++;
            o--;
            z=0;

        }
    }


}
