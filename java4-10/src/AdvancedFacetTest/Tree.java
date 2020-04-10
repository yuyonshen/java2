package AdvancedFacetTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val; }
}
public class Tree {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String line=scanner .next();
            TreeNode root=build(line);
            inOrder(root);
            System.out.println( );
        }
    }

    private static void inOrder(TreeNode root) {
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    private static int index=0;
    private static TreeNode build(String line) {
        index=0;
        return createTree(line);
    }

    private static TreeNode createTree(String line) {
        char cur=line.charAt(index);
        if (cur == '#') {
            return null;
        }
        TreeNode root=new TreeNode(cur);
        index++;
        root.left=createTree(line);
        index++;
        root.right=createTree(line);
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
    //给定一个二叉树,找到该树种的两个指定节点的最近公共祖先.
    private TreeNode lac=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        findNode(root,p,q);
        return lac;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return false;
        }
        int left=findNode(root.left, p, q) ? 1:0;
        int right=findNode(root.right,p,q) ? 1:0;
        int mid=(q==root||p==root) ? 1:0;
        if(mid+left+right==2){
            lac=root;
        }
        return (left+right+mid)>0;
    }
    //二叉树搜索树转换为排序的双向链表
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode leftTail=left;
        while(leftTail!=null&&leftTail.right!=null){
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
        return left==null?pRootOfTree:left;
    }
    //根据二叉树的先序和中序遍历构造二叉树
    private  int indexs;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        index=0;
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
        indexs++;
        int pos=find(inorder, left, right, root.val);
        root.left=buildTreeHelper(preorder,inorder,left,pos);
        root.right=buildTreeHelper(preorder,inorder,pos+1,right);
        return root;
    }

    private int find(int[] inorder, int left, int right, int val) {
        for(int i=left;i<right;i++){
            if(val==inorder[i]){
                return i;
            }
        }
        return -1;
    }
    //二叉树创建字符串
    StringBuffer sb=new StringBuffer();
    public String tree2str(TreeNode t){
        if(t==null){
            return "";
        }
        helply(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void helply(TreeNode t) {
        if(t==null){
            return ;
        }
        sb.append("(");
        sb.append(t.val);
        if(t.left==null&&t.right!=null){
            sb.append("()");
        }
        helply(t.left);
        helply(t.right);
        sb.append(")");

    }
}
