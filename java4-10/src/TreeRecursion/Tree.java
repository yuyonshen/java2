package TreeRecursion;

import java.lang.reflect.Array;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
    //使用递归方式先序遍历
    public static void preOder(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        preOder(root.left);
        preOder(root.right);
    }
    //使用递归中序遍历二叉树
    public static void inOder(TreeNode root){
        if(root==null){
            return ;
        }
        inOder(root.left);
        System.out.println(root.val);
        inOder(root.right);
    }
    //使用递归的方式后序遍历二叉树
    public static void posOrder(TreeNode root){
        if(root==null){
            return ;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.println(root.val);
    }
    //二叉树的层序遍历
    public static void levelOrder(TreeNode root){
       Queue<TreeNode> queue=new LinkedList<>();
       TreeNode cur=root;
       queue.offer(cur);
       while(!queue.isEmpty()){
           System.out.println(queue.poll().val);
           if(root.left!=null){
               queue.offer(root.left);
           }
           if(root.right!=null){
               queue.offer(root.right);
           }
       }

    }
}
