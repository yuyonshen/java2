package TreeNode;

import sun.awt.image.GifImageDecoder;

import java.util.ArrayList;
import java.util.List;
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode rigth;

    public TreeNode(int val){
        this.val=val;
    }
}

public class Tree {
    //使用前序遍历整个二叉树,将二叉树中的元素增加到将集合中;
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.rigth));
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
        result.addAll(inorderTraversal(root.rigth));
        return result;
    }
    //二叉树的后序;
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.rigth));
        result.add(root.val);
        return result;
    }
    //判断两颗树是否相同
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
        return isSameTree(p.left,q.left)&&isSameTree(p.rigth,q.rigth);
    }
    //一棵树是另外一颗树的子树;
    public boolean isSubtree(TreeNode s, TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        boolean ret=false;
        if(s.val==t.val){
           ret= isSameTree(s.left,t.left)&&isSameTree(s.rigth,t.rigth);
        }
        return ret||isSubtree(s.left,t)||isSubtree(s.rigth,t);

    }
    //检查一颗二叉树的最大深度
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.rigth==null){
            return 1;
        }
        int rootleft=maxDepth(root.left);
        int rootrigth=maxDepth(root.rigth);
        return 1+ Math.max(rootleft,rootrigth);
    }
    //判断这个二叉树是否为平和二叉树
    //平衡二叉树的左右深度之差不能大于一和左右深度不能小于一
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left==null&&root.rigth==null){
            return true;
        }
        int rootleft=maxDepth(root.left);
        int rootrigth=maxDepth(root.rigth);
        if(rootleft-rootrigth<-1||rootleft-rootrigth>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.rigth);
    }
    //判断是否为对称二叉树
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return Cur(root.left,root.rigth);
    }

    private boolean Cur(TreeNode A,TreeNode B) {
        if(A==null&&B==null){
            return true;
        }
        if(A==null||B==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return Cur(A.left,B.rigth)&&Cur(A.rigth,B.left);
    }
}
