package LeetCode;


import javax.swing.plaf.basic.BasicScrollPaneUI;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Solution3 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean reslut = false;
        if(root1 ==null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            reslut = helper(root1, root2);
        }
        if(reslut != true){
            reslut = HasSubtree(root1.left, root2);
        }
        if(reslut != true){
            reslut = HasSubtree(root1.right, root2);
        }
        return reslut;
    }

    private boolean helper(TreeNode begin, TreeNode beginSub) {
        if(beginSub == null){//beginSub为null，说明已经比较完了
            return true;
        }
        if(begin == null){ //begin为空，说明beginSub不是你的子树
            return false;
        }
        if(begin.val != beginSub.val){
            return false;//说明，整树中，有不相等的节点
        }
        //分别比较左右左右子树，必须都是相等的
//这里大家深度想想递归是怎么返回的【整个递归的结果，由最深层调用的结果决定】
        return helper(begin.left, beginSub.left) &&
                helper(begin.right, beginSub.right);
    }
}
