import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}
public class Tree3 {
    //判断这个树是否为完全二叉树
    public boolean isCompleteTree(TreeNode root){
        //完全二叉树分为两个阶段
        //1.每个节点都有左右子树
        //2节点的左右子树都为空
        if(root==null){
            return false;
        }
        boolean isSecondStep = false;
        //创建一个队列
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(!isSecondStep){
                //第一阶段左右子树都不为空
                if(cur.left!=null&&cur.right!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }//左子树为空右子树不为空,则判定不是完全二叉树
                else if(cur.left==null&&cur.right!=null){
                    return false;
                }//进入第二阶段的起始位置
                else if(cur.left!=null&&cur.right==null){
                    isSecondStep=true;
                    queue.offer(cur);
                }else{
                    if(cur.left!=null||cur.right!=null){
                        return false;
                    }
                }

            }

        }
        return true;
    }
}
