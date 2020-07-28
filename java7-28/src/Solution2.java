/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 二叉搜索树的后序遍历特点是所有左子树的节点值都小于根结点,所有右子树的节点都大于根结点.
 */
public class Solution2 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length < 0){
            return false;
        }
        return VerifySquenceOfBSTHelper(sequence, 0, sequence.length-1);
    }

    private boolean VerifySquenceOfBSTHelper(int[] sequence, int start, int end) {
        if(start >= end){
            return true;
        }
        int root = sequence[end];
        int i = 0;
        while(i < end && sequence[i] < end){
            i++;
        }
        for(int j = i; j < end; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        return VerifySquenceOfBSTHelper(sequence, start, i-1) &&
                VerifySquenceOfBSTHelper(sequence, i+1, end-1);
    }
}
