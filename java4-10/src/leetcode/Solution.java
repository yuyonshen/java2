package leetcode;

public class Solution {
    //将字符串中的的大写字母转换为小写字母
    public String toLowerCase(String str){
        char[] arr=new char[str.length()];
        char a;
        for(int i=0;i<str.length();i++){
             a=str.charAt(i);
            if(a<='Z'&&a<='A'){
                a=(char)(a+32);
            }
            arr[i]=a;
        }
        return new String(arr);
    }
    //向数组中的元素向右移动k个位置
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            int z=nums[nums.length-1];
            for(int j=nums.length-1-1;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0]=z;
        }
    }
    //移除数组中与val相同的元素,返回组数的新长度
    public int removeElement(int[] nums, int val) {
//        int index=0;
//        int size=nums.length;
//        for(int i=0;i<size;i++){
//            if(nums[i]!=val){
//                index++;
//            }else{
//                for(int j=i+1;j<size;j++){
//                    nums[j-1]=nums[j];
//                }
//                size--;
//            }
//
//        }
//        return index;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
    //给定一个有序数组,在给定一个数,在目标数组找到这个数就返回下标,如果没有找到就放回插入位置
    public int searchInsert(int[] nums, int target){
        int left=0;
        int right=target-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                nums[mid]=target;
                return mid;
            }
        }
        return left;
    }
}
