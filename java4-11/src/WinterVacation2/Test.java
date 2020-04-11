package WinterVacation2;

import javax.management.monitor.StringMonitor;

public class Test {
    //最后一个单词的长度
    public int lengthOfLastWord(String s) {
        if(s==null&&s.length()==0){
            return 0;
        }
        int num=0;
        String s1=s.trim();
        for(int i=s1.length()-1;i>=0;i--){
            if(s1.charAt(i)!=' '){
                num++;
            }else{
                break;
            }
        }
        return num;
    }
    //给定连个有序数组将nums2中的数字有序的插入到nums1中
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //首先创建一个数组将nums1和nums2中的数据都保存下来
        int[] arr=new int[m+n];
        int index=0;
        for(int i=0;i<m;i++){
            arr[index]=nums1[i];
            index++;
        }
        for(int i=0;i<n;i++){
            arr[index]=nums2[i];
            index++;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        nums1=arr;
        for(int i=0;i<n;i++){
            nums1[m]=nums2[i];
            m++;
        }
        for(int j=0;j<m+n-1;j++){
            for(int a=j+1;a<m+n;a++){
                if(nums1[j]>nums1[a]){
                    int temp=nums1[a];
                    nums1[a]=nums1[j];
                    nums1[j]=temp;
                }
            }
        }
    }
    //给定一个数组,如果某个元素的值在这个数组中出现两次一样返回true
    public boolean containsDuplicate(int[] nums) {
            int num=0;
            for(int i=0;i<nums.length-1;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j]){
                        return true;
                    }
                }

            }
        return false;
    }
    //你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
    // 而字符可能被输入 1 次或多次。
    public boolean isLongPressedName(String name, String typed) {
//        if (name.length() > typed.length()) {
//            return false;
//        }
//        int j=0;
//        int i=0;
//        while(j<name.length()&&i<typed.length()){
//            if(name.charAt(j)==typed.charAt(i)){
//                i++;
//                j++;
//            }else if(i>0&&typed.charAt(j)==name.charAt(j-1)){
//                j++;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
    int i=0;
    for(int j=0;j<typed.length();j++){
        if(name.charAt(i)==typed.charAt(j)){
            i++;
        }
        if(i==name.length()){
            break;
        }
    }
    return (i==name.length())?true:false;
    }
}
