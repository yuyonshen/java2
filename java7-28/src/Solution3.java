import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 这是一个典型的DFS回溯的算法
 * //回溯法本质是一个基于DFS的穷举的过程
 * //1. 先添加值
 * //2. 在判定现有结果是否满足条件
 * //3. DFS
 * //4. 回退
 */
public class Solution3 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null ){
            return result;
        }
        FindPathHelper(root, target, result, list);
        return result;
    }

    private void FindPathHelper(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
          if(root == null){
              return;
          }
          list.add(root.val);
          target -= root.val;
          if(root.left == null && root.right == null && target ==0){
              result.add(new ArrayList<>(list));
          }
          FindPathHelper(root.left, target, result, list);
          FindPathHelper(root.right, target, result, list);
          list.remove(list.size()-1);
    }
}
