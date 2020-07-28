/*

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。
解决思路:1这个题我们可以使用map的的方式来实现.
2我们可以给这个数组进行排序.那么中间元素就是出现最多的次数
3.我们遍历这个数组,去电相邻的两个不同的元素.到了最后剩下的就是我们需要找的元素.

 */
public class Solution5 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int index = array[0];
        int nums = 1;
        for(int i = 1; i < array.length; i++){
            if(index == array[i]){
                nums++;
            } else if(nums == 0 ){
                index = array[i];
                nums = 1;
            }else{
                nums--;
            }
        }
        int time = 0;
        for(int i = 0; i < array.length; i++){
            if(index == array[i]){
                time++;
            }
        }
        return time > (array.length)/2 ? index : 0;
    }
}
