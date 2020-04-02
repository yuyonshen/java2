package TreeNode2;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }
public class Tree2 {
    //二叉树的分层遍历
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

    if(root==null){
        return result;
    }
    helper(root,0);
    return result;
    }

    private void helper(TreeNode root, int i) {
        if(result.size()==i){
          result.add(  new ArrayList<>());
        }
        result.get(i).add(root.val);
        if(root.left!=null){
           helper(root.left,i+1);
        }
        if(root.right!=null){
            helper(root.right,i+1);
        }
    }

}
