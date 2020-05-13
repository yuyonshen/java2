package ProgrammingProblem;

public class Solution {
    //实现一个二分查找
    public int BinarySearch(int[] array,int num){
        int length=array.length;
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(array[mid]>num){
                right=mid-1;
            }else if(array[mid]<num){
                left=mid+1;
            }else{
                return array[mid];
            }
        }
        return -1;
    }
    public double add(){
        double reslut=0;
        for(int i=0;i<22;i++){
            int a=2;
            int b=1;
            double divide=a/b;
            reslut+=divide;
            a=a+b;
            b=a;
        }
        return reslut;
    }

}
