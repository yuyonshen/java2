package Tree;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode rigth;

    public TreeNode(int val) {

        this.val = val;
    }
}
public class Tree {
    //二叉树的先序遍历,非递归迭代实现
    public static void preOrderByLoop(TreeNode root) {
        //判断root是否为空
        if (root == null) {
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val+" ");
            if (cur.rigth != null) {
                stack.push(root.rigth);
            }
            if (cur.left != null) {
                stack.push(root.left);
            }
        }
    }
        //二叉树的中序遍历,非递归的方法实现
        public static void inOrderByLoop(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (true) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                if (stack.isEmpty()) {
                    break;
                }
                TreeNode pre = stack.pop();
                System.out.print(pre.val + " ");
                cur = pre.rigth;
            }
        }

           //二叉树的后序遍历,使用非递归的实现方式实现
            public static void postOrderByLoop(TreeNode root){
               if(root==null){
                   return ;
               }
               Stack<TreeNode> stack=new Stack<>();
               TreeNode cur=root;
               TreeNode prve=null;
               while(true) {
                   while (cur != null) {
                       stack.push(cur);
                       cur = cur.left;
                   }
                   if(stack.isEmpty()){
                      break;
                   }
                   TreeNode top=stack.peek();
                   if(top.rigth==null||prve==top.rigth){
                       System.out.print(top.val+" ");
                       stack.pop();
                       prve=top;
                   }else{
                       cur=cur.rigth;
                   }
               }
            }

    public static void main(String[] args) {
        TreeNode root = build();
        inOrderByLoop(root);
        preOrderByLoop(root);
        postOrderByLoop(root);
    }
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.rigth = c;
        b.left = d;
        b.rigth = e;
        e.left = g;
        c.rigth = f;
        return a;
    }

}
