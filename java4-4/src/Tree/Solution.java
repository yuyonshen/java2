package Tree;


import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    public TreeNode(int val){
        this.val=val;
    }
}

public class Solution {
    //二叉树的分层遍历
    //将以集合的形式每一层的元素增加到集合中
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        //判断root是否为空
        if(root==null){
            return result;
        }
        //写一个辅助方法层次遍历树,将元素增加到集合中
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
    //二叉树的最近公共祖先
    //先创建一个最近公共祖先的节点,初始化他为空
    private TreeNode lac=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
        int left=findNode(root.left,p,q)?1:0;
        int rigth=findNode(root.right,p,q)?1:0;
        int mid=(p==root||q==root)?1:0;
        if(left+rigth+mid==2){
            lac=root;
        }
        return (left+rigth+mid)>0;
    }
    //二叉搜索树转换为排列双向链表;
    public TreeNode Convert(TreeNode pRootOfTree) {
    //基于递归的方式完成双向链表的构建,为了保证链表的有序性,使用中序遍历的方式
    //儿茶搜索树的中序结果是有序的
    if(pRootOfTree==null){
        return null;
    }
    if(pRootOfTree.left==null&&pRootOfTree.right==null){
        return pRootOfTree;
    }
    //使用递归的方式最想访问左子树
        TreeNode left=Convert(pRootOfTree.left);
    //找到为节点;
    TreeNode leftTail=left;
    while(leftTail!=null&&leftTail.right!=null){
        leftTail=leftTail.right;
    }
    if(left!=null){
        leftTail.right=pRootOfTree;
        pRootOfTree.left=leftTail;
    }
    TreeNode right=Convert(pRootOfTree);
    if(right!=null){
        right.left=pRootOfTree;
        pRootOfTree.right=right;
    }
    return left==null?pRootOfTree:left;

    }
    //根据一棵树的前序遍历与中序遍历构造二叉树
    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    index=0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int rigth) {
        if(left>=rigth){
            return null;
        }
        if(index>preorder.length){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index]);
        index++;
        int pos=find(inorder,left,rigth,root.val);
        root.left=buildTreeHelper(preorder,inorder,left,pos);
        root.right=buildTreeHelper(preorder,inorder,pos+1,rigth);
        return root;
    }

    private int find(int[] inorder, int left, int rigth, int val) {
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    //你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    //
    //空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
    private StringBuffer sb=new StringBuffer();
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        //借助helper()方法先序遍历
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if(t==null){
            return;
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
    //根据一棵树的中序遍历与后序遍历构造二叉树
    private int num;
    int arr[];
    public TreeNode buildTree2(int[] inorder, int[] postorder) {

        num=0;
        int arr[]=new int[postorder.length];
        int j=0;
        for(int i=postorder.length-1;i<=0;i--){
            arr[j]=postorder[i];
            j++;
        }
    return buildTreeHelper2(arr, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper2(int[] arr, int[] inorder, int left, int rigth) {
    if(left>=rigth){
        return null;
    }
    if(num>arr.length){
        return null;
    }

    TreeNode root=new TreeNode(arr[num]);
    num++;
    int pos= find2(inorder,left,rigth,root.val);
    root.right=buildTreeHelper2(arr,inorder,pos+1,inorder.length);
    root.left=buildTreeHelper2(arr,inorder,left,pos);
    return root;
    }

    private int find2(int[] inorder, int left, int rigth, int val) {
        for(int i=0;i<inorder.length;i++){
            if(val==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}
