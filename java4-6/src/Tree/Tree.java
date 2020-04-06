package Tree;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}
public class Tree {
    //是有非递归的方式先序遍历这棵树
    public static void preOrder(TreeNode root){
        //首先判断这个树是否为空树
        if(root==null){
            return ;
        }
        //不为空树进行一下操作
        //1.首先建立一个栈
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){

            TreeNode cur=stack.pop();
            System.out.print(cur.val+" ");

            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }
    //使用非递归的方式进行中序遍历
    public static void inOrder(TreeNode root){
       if(root==null){
           return ;
       }
       Stack<TreeNode> stack=new Stack<>();

       TreeNode cur=root;
       while(true){
          while(cur!=null){
              stack.push(cur);
              cur=cur.left;
          }
           if(stack.isEmpty()){
               break;
           }
           TreeNode pre=stack.pop();
           System.out.print(pre.val+" ");
           cur=pre.right;
       }
    }
    //使用非递归的方式后序遍历树
    public static void posOrder(TreeNode root){
        if(root==null){
            return ;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode pre=null;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }

            TreeNode mid=stack.peek();
            if(mid.right==null||pre==mid.right){
                System.out.print(mid.val+" ");
                stack.pop();
                pre=mid;
            }else {
                cur = mid.right;
            }
        }
    }
    public static TreeNode build(){
        TreeNode A=new TreeNode(1);
        TreeNode B=new TreeNode(2);
        TreeNode C=new TreeNode(3);
        TreeNode D=new TreeNode(4);
        TreeNode E=new TreeNode(5);
        TreeNode F=new TreeNode(6);
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.right=F;
        return A;
    }

    public static void main(String[] args) {
        TreeNode root=build();
        //preOrder(root);
        //inOrder(root);
        posOrder(root);
    }
}
