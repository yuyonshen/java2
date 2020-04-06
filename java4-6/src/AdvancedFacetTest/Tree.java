package AdvancedFacetTest;

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
    public Tree(int index) {
        Tree.index = index;
    }

    //二叉树的构建及遍历
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String line=scanner.next();
            TreeNode root=build(line);
        }
    }

    private static int index=0;
    private static TreeNode build(String line) {
        index=0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        char cur=line.charAt(index);
        if (cur == '#') {
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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null){
            return result;
        }
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int i) {
        if(result.size()==i){
           result.add(new ArrayList<>());
        }
        result.get(i).add(root.val);
        if(root.left!=null){
            helper(root.left,i+1);
        }
        if(root.right!=null){
            helper(root.right,i+1);
        }
    }
    //给定一个二叉树没找到该树中的两个指定节点的最近公共祖先
    private  TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            if(root==null){
                return null;
            }
        findNode(root, p, q);
            return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return false;
        }
        int left=findNode(root.left,q,p)?1:0;
        int right=findNode(root.right,q,p)?1:0;
        int mid=(q==root||p==null)?1:0;
        if(left+right+mid==2){
             lca=root;
        }
        return left+right+mid>0;
    }
    //二叉搜索树转换为双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left= Convert(pRootOfTree.left);
        TreeNode leftTail=left;
        while(leftTail.left!=null&&leftTail.right!=null){
            leftTail=leftTail.right;
        }
        if(left!=null){
            leftTail.right=pRootOfTree;
            pRootOfTree.left=leftTail;
        }
        TreeNode right=Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }
        return left==null? pRootOfTree:left;
    }
    //根据一棵树的前序和中序构造二叉树
    private int indexs;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        indexs=0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
    if(left>=right){
        return null;
    }
    if(indexs>preorder.length){
        return null;
    }
    TreeNode root=new TreeNode(preorder[indexs]);
    index++;
    int pos=find(inorder, left, right, root.val);
    root.left=buildTreeHelper(preorder,inorder,left,pos);
    root.right=buildTreeHelper(preorder,inorder,pos+1,right);
    return root;

    }

    private int find(int[] inorder, int left, int right, int val) {
        for(int i=0;i<inorder.length;i++){
            if(val==inorder[i]){
                return i;
            }
        }
        return -1;
    }
    //二叉树的创建字符串
    StringBuffer sb=new StringBuffer();
    public String tree2str(TreeNode t){
        if(t==null){
            return " ";
        }
        help(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    private void help(TreeNode t) {
        if(t==null){
            return;
        }
        sb.append("(");
        sb.append(t.val);
        help(t.left);
        if(t.left==null&&t.right!=null){
            sb.append("()");
        }
        help(t.right);
        sb.append(")");
    }
}
