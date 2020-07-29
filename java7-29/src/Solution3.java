import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution3 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public int TreeDepth(TreeNode root) {
//            if(root == null){
//                return 0;
//            }
//        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.offer(root);
        int num = 0;
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i = 0; i < s; i++){
               TreeNode t = queue.poll();
                if(t.left != null){
                    queue.offer(t.left);
                }
                if(t.right != null){
                    queue.offer(t.right);
                }
            }
            num++;
        }
        return num;
    }
}
