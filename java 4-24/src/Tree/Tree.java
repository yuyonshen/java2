package Tree;

import java.lang.reflect.Array;
import java.util.*;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {
    //判断是否为相同的二叉树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //检查t是否为s的子二叉树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        boolean ret=false;
        if(s.val==t.val){
           ret=isSameTree(s,t);
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t)||ret;
    }
    //找出这个树的最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
    //判断一颗二叉树是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if(left-right>1||left-right<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //判断是否为对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        return helply(root.left,root.right);
    }

    private boolean helply(TreeNode a, TreeNode b) {
        if(a==null&&b==null){
            return true;
        }
        if(a==null||b==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }
        return helply(a.left,b.right)&&helply(a.right,b.left);
    }
    //判断一颗树是否为完全二叉树
    public  boolean isCompleteTree(TreeNode root){
        //堆二叉树层序遍历
        Queue<TreeNode> queue =new LinkedList<>();
        if(root==null){
            return true;
        }
        boolean ret=false;
        queue.offer(root);
        while(queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(!ret){
                if(cur.left!=null&&cur.right!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left==null&&cur.right!=null){
                    return false;
                }else if(cur.left!=null&&cur.right==null){
                    ret=true;
                    queue.offer(cur.right);
                }else{
                    ret=true;
                }
            }else{
                if(cur.right!=null||cur.right!=null){
                    return false;
                }
            }
        }
        return true;
    }
    //二叉树的分层遍历
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return result;
        }
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int a) {
        if(a==result.size()){
           result.add(new ArrayList<>());
        }
        result.get(a).add(root.val);
        if(root.left!=null){
            helper(root.left,a+1);
        }
        if(root.right!=null){
            helper(root.right,a+1);
        }
    }
    //找树的最近公共祖先
    private TreeNode lac=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        findNode(root,p,q);
        return lac;
    }

    private boolean findNode(TreeNode root,TreeNode p, TreeNode q) {
        if(root==null){
            return false;
        }
        int left=findNode(root.left,q,p)?1:0;
        int right=findNode(root.right,q,p)?1:0;
        int mid=(p==root||q==root)?1:0;
        if(left+right+mid==2){
            lac=root;
        }
        return (left+right+mid)>0;


    }
    //见二叉树变为双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {

    }
}
