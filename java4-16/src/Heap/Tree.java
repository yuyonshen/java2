package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
    //二叉树的构建及遍历
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line=scanner.next();
            TreeNode root=build(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if(root==null) {
            return;
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
    //二叉树的分层遍历
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null){
            return result;
        }
        helply(root,0);
        return result;
    }

    private void helply(TreeNode root, int i) {
        if(result.size()==i){
            result.add(new ArrayList<>());
        }
        result.get(i).add(root.val);
        if(root.left!=null){
            helply(root.left,i+1);
        }
        if(root.right!=null){
            helply(root,i+1);
        }
    }
   //将一个二叉树转换为一个双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode Tailleft=left;
        while(Tailleft!=null&&Tailleft.right!=null){
            Tailleft=Tailleft.right;
        }
        if(left!=null){
            Tailleft.right=pRootOfTree;
            pRootOfTree.left=Tailleft;
        }
        TreeNode right=Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }
        return left==null? pRootOfTree:left;

    }
    //根据一棵树的前序遍历和中序遍历构造二叉树
    private int indexs;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexs = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
    if(left>=right){
        return null;
    }
    if(indexs>=preorder.length){
        return null;
    }
    TreeNode root=new TreeNode(preorder[indexs]);
    int pos=find(inorder,left,right, root.val);
    root.left=buildTreeHelper(preorder,inorder,left,pos);
    root.right=buildTreeHelper(preorder,inorder,pos+1,right);
    return root;
    }

    private int find(int[] inorder, int left, int right, int val) {
        for(int i=left;i<right;i++){
            if(inorder[i]==val){
                return val;
            }
        }
        return -1;
    }
    //二叉树创建字符串
    private  StringBuffer sb=new StringBuffer();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if(t==null){
            return ;
        }
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if(t.left==null&&t.right!=null){
        sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }
}
