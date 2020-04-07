package Tree;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
    //实现非递归前序遍历
    public static void prrOder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return ;
        }
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
    //实现非递归的方式中序遍历
    public static void inOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return ;
        }
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
    //实现非递归的方式进行后序变遍历
    public static void postOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return ;
        }
        TreeNode prev=null;
        TreeNode cur=root;
        while(true){

            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode num= stack.peek();

            if(num.right==null||prev==num.right){

                System.out.print(num.val+" ");
                stack.pop();
                prev=num;
            }else {


                cur = num.right;
            }
        }
    }

    public static TreeNode build(){
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(5);
        TreeNode f=new TreeNode(6);
        TreeNode g=new TreeNode(7);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        d.left=g;
        c.right=f;
        return a;

    }

    public static void main(String[] args) {
        TreeNode root=build();
        //prrOder(root);
        //nOrder(root);
        postOrder(root);
    }
}
