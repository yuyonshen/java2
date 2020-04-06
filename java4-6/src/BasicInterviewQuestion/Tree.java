package BasicInterviewQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}
public class Tree {
    //二叉树的前序遍历;
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
    //检查两颗树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(q==null&&p==null){
            return true;
        }
        if(q==null||p==null){
            return false;
        }
        if(q.val!=p.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(q.right,p.right);
    }
    //判断一颗树的子树是否包含另外一颗树
    public boolean isSubtree(TreeNode s, TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        boolean set=false;
        if(s.val==t.val){
           set=isSameTree(s,t);
        }
        return set||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    //二叉树的最大深度
    public int maxDepth(TreeNode root){
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
        if(left-right<-1||left-right>1){
            return false;
        }
        return isBalanced(root.right)&&isBalanced(root.left);
    }
    //判断一棵树是否为对称二叉树
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }

        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
    //层序遍历二叉树
    public void  levelOrder(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return ;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur=queue.poll();
            System.out.print(cur.val+" ");
            if(root.left!=null) {
                queue.offer(root.left);
            }
            if(root.right!=null) {
                equals(root.right);
            }
        }
    }
    public boolean isCompleteTree(TreeNode root){
        if(root==null){
            return true;
        }
        boolean step=false;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(!step){
                if(cur.left!=null&&cur.right!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left==null&&cur.right!=null){
                    return false;
                }else if(cur.left!=null&&cur.right==null){
                    step=true;
                    queue.offer(cur.left);
                }else{
                    step=true;
                }

            }else{
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
            }
        }
        return true;
    }
}
