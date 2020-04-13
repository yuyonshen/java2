package Sort;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Sort {
    //快速排序
    //使用递归的方式实现
    public static void QuickSort(int[] array){
        //首先创建一个方法
        QuickSortHeap(array,0,array.length-1);
    }

    private static void QuickSortHeap(int[] array, int left, int right ) {
        if(left>=right){
            return ;
        }
        int mid=helply(array,left,right);
        QuickSortHeap(array,left,mid-1);
        QuickSortHeap(array,mid+1,right);
    }

    private static int helply(int[] array, int left, int right) {
        int start=left;
        int end = right;
        int base=array[right];
        while(start<end){
            if(start<end&&array[start]<array[right]){
                start++;
            }
            if(start<end&&array[end]>array[right]){
                end--;
            }
            swap(array,start,end);
        }
        swap(array,start,right);
        return start;
    }

    private static void swap(int[] array, int start, int end) {
        int temp=array[start];
        array[start]=array[end];
        array[end]=temp;
    }
    //使用非递归的方式实现快速排序
    public static void HeapSort(int[] array){
        //首先需要借助一个栈来完成
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left=stack.pop();
            int right=stack.pop();
            if(left>=right){
                continue;
            }
            int mid=helply(array,left,right);
            stack.push(right);
            stack.push(mid+1);

            stack.push(mid-1);
            stack.push(left);
        }
    }
//归并排序,递归的方式实现
    //借助连个有序数组,合并一个有序数组的排序方式
    public static void MergeSort(int[] array){
        megerSortHelp(array,0,array.length);

    }

    private static void megerSortHelp(int[] array, int low, int high) {
    if((high-low)<=1){
        return ;
    }
         int mid=(high+low)/2;
        megerSortHelp(array,low,mid);
        megerSortHelp(array,mid,high);
        Oedered(array,low,mid,high);

    }

    public static void Oedered(int[] array, int low,int mid ,int high){
        int[] nums=new int[high-low];
        int num=0;
        int left=low;
        int right=mid;
        while(left<mid&&right<high){
            if(array[left]>=array[right]){
                nums[num]=array[right];
                right++;
                num++;
            }
            else{
                nums[num]=array[left];
                left++;
                num++;
            }
        }
        while(left<mid){
            nums[num]=array[left];
            left++;
            num++;
        }
        while(right<high){
            nums[num]=array[right];
            right++;
            num++;
        }
        for(int i=0;i<nums.length;i++){
            array[low+i]=nums[i];
        }

    }
    //使用非递归的方式进行归并排序
    public static void mergeSort1(int[] array){
        for(int gap=1;gap<array.length;gap*=2){
            for(int i=0;i<array.length;i+=2*gap){
                int low=i;
                int mid=i+gap;
                int end=2*gap+i;
               if(mid>array.length){
                   mid=array.length;
               }
               if(end>array.length){
                   end=array.length;
               }
                Oedered(array,low,mid,end);
            }
        }
    }
    public static void main(String[] args) {
        int[] array={9,5,2,7,3,6,8};
       // QuickSort(array);
        //HeapSort(array);
        //MergeSort(array);
        mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
