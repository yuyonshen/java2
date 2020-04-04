package Tree4;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}
public class Tree {
    //二叉树的分层遍历
    //首相创建一个集合类
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null){
            return result;
        }
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root,int i) {
        if(result.size()==i){
            result.add(new ArrayList<>());
        }
        result.get(i).add(root.val);
        if(root.left!=null){
            helper(root.left,i+1);
        }
        if(root.right!=null){
            helper(root.right,i+1);
        }
    }
    //给定一个二叉树.找到该树种两个指定节点的最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root,q,p);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode q, TreeNode p) {
        if(root==null){
            return false;
    }
        int left=findNode(root.left,q,p)?1:0;
        int right=findNode(root.right,q,p)?1:0;
        int mid=(p==root||q==root)?1:0;
        if(mid+left+right==2){
            lca=root;
        }
        return (left+right+mid)>0;
    }
    //儿茶搜索树转换为一个双向链表
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode leftTail=left;
        while(leftTail!=null&&leftTail.right!=null){
            leftTail=leftTail.right;
        }
        if(left!=null){
            leftTail.right=pRootOfTree;
            pRootOfTree.left=leftTail;
        }
        TreeNode right= Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }
        return left==null?leftTail:left;
    }
}
