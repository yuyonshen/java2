/**
 * 找出连续子序列的最大和
 * 定义状态f(i);yii下标结尾的最大子序列的和.
 * 状态地推 f(i)=max(f(i-1)+array[i], array[i]);
 * 初始状态f(0) = array[0] ,max = array[0];
 */
public class Solution7 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int num = array[0];
        int max_value = array[0];
        for (int i = 1; i < array.length; i++) {
            if (num >= 0) {
                num += array[i];
            } else {
                num = array[i];
            }
            if (max_value < num) {
                max_value = num;
            }
        }
        return max_value;
    }
}
