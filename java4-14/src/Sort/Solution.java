package Sort;

import sun.awt.EventQueueItem;

import javax.swing.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    //实现一个快速排序的方法
    //使用递归的方式完成的
    public static void QuickSort(int[] array) {
        QuickSortHelp(array,0,array.length-1);
    }

    private static void QuickSortHelp(int[] array, int left, int right) {
        if(left>=right){
            return ;
        }
        int mid=helply(array,left,right);
        QuickSortHelp(array,left,mid-1);
        QuickSortHelp(array,mid+1,right);
    }

    private static int helply(int[] array, int left, int right) {
        int start=left;
        int end=right;
        int num=array[right];
        while(start<end){
            while(start<end&&array[start]<=num){
                start++;
            }
            while(start<end&&array[end]>=num){
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
    //使用非递归的方式实现
    public static void QucikSort1(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left= stack.pop();
            int right=stack.pop();
            if(left>=right){
                continue;
            }
            int mid=helply(array,left,right);
            stack.push(mid-1);
            stack.push(left);

            stack.push(right);
            stack.push(mid+1);
        }
    }
    //试下归并排序
    //归并排序的试下是基于连个有序数组,合并成一个有序数组
    public static void MergeSort(int[] array ){
        mergeSorthelp(array,0,array.length);
    }

    private static void mergeSorthelp(int[] array, int low, int high) {
        if(high-low<=1){
            return ;
        }
        int mid=(low+high)/2;
        mergeSorthelp(array,low,mid);
        mergeSorthelp(array,mid,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] newNums=new int[high-low];
        int left=low;
        int right=mid;
        int nums=0;
        while(left<mid&&right<high){
            if(array[left]<array[right]) {
                newNums[nums]=array[left];
                left++;
                nums++;
            }else{
                newNums[nums]=array[right];
                right++;
                nums++;
            }
        }
        while(left<mid){
            newNums[nums]=array[left];
            left++;
            nums++;
        }
        while(right<high){
            newNums[nums]=array[right];
            right++;
            nums++;
        }
        for(int i=0;i<newNums.length;i++){
            array[low+i]=newNums[i];
        }
    }
    //使用非递归的方式实现归并排序
    public static void MergeSort1(int[] array){
        for(int gap=1;gap<array.length;gap*=2){
            for(int j=0;j<array.length;j+=gap*2){
                int low=j;
                int mid=j+gap;
                int high=j+gap*2;
                if(mid>array.length){
                    mid=array.length;
                }
                if(high>array.length){
                    high=array.length;
                }
                merge(array,low,mid,high);
            }
        }
    }
    //堆排序的方法
    public static void HeapSort(int[] array){
        createHeap(array);
        for(int i=0;i<array.length-1;i++){
            int num=array.length-i;
            swap(array,0,num-1);
            num--;
            createHeapHelp(array,num,0);
        }
    }

    private static void createHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
            createHeapHelp(array,array.length,i);
        }
    }

    private static void createHeapHelp(int[] array,int size, int index) {

        int parent=index;
        int child=index*2+1;
        while(child<size){
            if(child+1<size&&array[child]<array[child+1]){
                child=child+1;
            }
            if(array[parent]<array[child]){
                int temp=array[parent];
                array[parent]=array[child];
                array[child]=temp;
            }else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }

    public static void main(String[] args) {
        int[] nums={2,5,7,1,9,10,8};
        //QuickSort(nums);
        //QucikSort1(nums);
        //MergeSort(nums);
        //MergeSort1(nums);
        HeapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
