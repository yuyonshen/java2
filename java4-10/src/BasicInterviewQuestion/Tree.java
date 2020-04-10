package BasicInterviewQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
   //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        TreeNode cur=root;
        result.add(cur.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
    //检查两颗树是否相同;
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(q.right,p.right);
    }
    //另一颗树的子树
    public boolean isSubtree(TreeNode s, TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return true;
        }
        boolean ret=false;
        if(s.val==t.val){
            ret=isSameTree(s,t);
        }
        return ret||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    //二叉树的深度
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return 1+ Math.max(leftDepth,rightDepth);
    }
    //判断一颗树是否为平衡二叉树
    public boolean isBalanced(TreeNode root){
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
    //堆成二叉树
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode q, TreeNode p) {
        if(q==null&&p==null){
            return true;
        }
        if(q.val!=p.val){
            return false;
        }
        return isMirror(q.left,p.right)&&isMirror(q.right,p.left);
    }
    //判断一颗树是否为完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if(root==null){
            return true;
        }
        boolean isSecondStep = false;
        Queue<TreeNode > queue=new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
           TreeNode cur=queue.poll();
           if(!isSecondStep){
               if(cur.left!=null&&cur.right!=null){
                   queue.offer(cur.left);
                   queue.offer(cur.right);
               }else if(cur.left==null&&cur.right!=null){
                   return false;
               }else if(cur.left!=null&&cur.right==null){
                   isSecondStep=true;
                   queue.offer(cur.left);
               }else{
                   isSecondStep=true;
               }
           }
           else{
               if(cur.left!=null||cur.right!=null){
                   return false;
               }
           }
       }
       return true;

    }
}
