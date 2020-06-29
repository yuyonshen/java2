package LeetCode;

public class Main {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBalance(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        int a=ismax(root.left);
        int b=ismax(root.right);
        if(a-b>1||a-b<-1){
            return false;
        }
        return isBalance(root.left)&&isBalance(root.right);
    }
    public int ismax(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftmax=ismax(root.left);
        int rightmax=ismax(root.right);
        return Math.max(rightmax,leftmax)+1;
    }
}
