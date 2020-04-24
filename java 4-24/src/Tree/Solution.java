package Tree;


import java.util.Scanner;

public  class Solution {
    static class TreeNode {
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            String tree=scanner.next();
            TreeNode root=bulid(tree);
            isOrder(root);
            System.out.println();
        }
    }

    private static void isOrder(TreeNode root) {
        if(root==null){
            return ;
        }
        isOrder(root.left);
        System.out.print(root.val);
        isOrder(root.right);
    }

    private static int index=0;
    private static TreeNode bulid(String tree) {
        index=0;
       return  createTreePreOrder(tree);
    }

    private static TreeNode createTreePreOrder(String tree) {
        char a=tree.charAt(index);
        if (a == '#') {
            return null;
        }
        TreeNode root=new TreeNode (a);
        index++;
        root.left=createTreePreOrder(tree);
        index++;
        root.right=createTreePreOrder(tree);
        return root;
    }


}
