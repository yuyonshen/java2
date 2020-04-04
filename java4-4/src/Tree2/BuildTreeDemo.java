package Tree2;

import java.util.Scanner;

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val){
        this.val=val;
    }
}
//二叉树的构建及遍历
public class BuildTreeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if(root==null){
            return ;
        }

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    private static int index=0;
    private static TreeNode build(String line) {
        index=0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        char cur=line.charAt(index);
        if(cur=='#'){
            return null;
        }
        TreeNode root=new TreeNode(cur);
        index++;
        root.left=createTreePreOrder(line);
        index++;
        root.right=createTreePreOrder(line);
        return root;
    }
}
