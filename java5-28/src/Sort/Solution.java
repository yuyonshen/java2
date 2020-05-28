package Sort;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

//多种排序
public class Solution {
    //插入排序
    //插入排序算法的时间复杂度为o(n^2),空间复杂度为o(1)
    //插入排序是一个问题性排序
    public static int[] InsertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int index=array[i];
            int j=i-1;
            for(;j>=0;j--) {
                if (array[j] > index) {
                    array[j + 1] = array[j];
                } else{
                    break;
                }
            }
            array[j+1]=index;

        }
        return array;
    }
    //希尔排序
    //希尔排序是基于插入排序的一个优化版本,当数组元素的数量太过于庞大的时候使用希尔排序更加快捷
    //希尔排序的时间复杂度最好为o(n),平均为o(n^1.3),最坏为o(n^2),空间复杂度为o(1).
    public static int[] shellSort(int[] array){
        int gap=array.length/2;
        while(gap>1){
            HillSort(array,gap);
            gap=gap/2;
        }
        HillSort(array,1);
        return array;
    }
    public static void HillSort(int[] array,int gap){
        for(int i=0;i<array.length;i++){
            int index=array[i];
            int j=i-gap;
            for(;j>=0;j--){
                if(index<array[j]){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=index;
        }
    }
    //选择排序
    //选择排序的时间复杂度为o(n^2),空间复杂度为o(1)
    //在if判断中如果不加等于号的时候为稳定性排序,负责就是不稳定排序
    public static int[] SelectSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
    //堆排序
    //借助堆来完成排序
    //首先在堆排序的时候我们需要建一个堆,如果是升序,我们建一个大堆,如果是一个降序我们需要见一个小堆
    //在建堆完成之后,我们交换收尾元素,之后重新进行向下调整堆.
    //堆排序的时间复杂对最好为o(n),平均为o(n^2),空间复杂度为o(1)最坏为o(n^2).
    public static int[] HeapSort(int[] array){
        //首先先建堆,需要建大堆
        createHeap(array);
        for(int i=0;i<array.length;i++){
            int headSize=array.length-i;
            swap(array,headSize-1,0);
            headSize--;
            shiftDown(array,headSize,0);

       }
        return array;
    }

    private static void createHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent=index;
        int child=parent*2+1;
        while(child<size){
            if(child+1<size&&array[child]<array[child+1]){
                child=child+1;
            }
            if(array[parent]<array[child]){
                swap(array,parent,child);
            }else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }

    private static void swap(int[] array, int i, int i1) {
        int temp=array[i];
        array[i]=array[i1];
        array[i1]=temp;
    }
    //冒泡排序
    //冒泡排序中的if语句的条件如果没有等于号就是一个稳定排序,负责不是一个稳定性排序
    //时间复杂度为o(n^2).空间复杂度为o(1)
    public static int[] bubbleSort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=array.length-1;j>=i;j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
        return array;
    }


    //快速排序(重要)
    //快速排序的时候首先需要找一个基准值,之后根据基准值来排序
    //时间复杂度为o(n*log(n))空间复杂度为o(log(n)).
    public static void QuickSort(int[] array){
            quickSortHelp(array,0,array.length-1);

    }

    private static void quickSortHelp(int[] array, int left, int right) {
        if(left>=right){
            return ;
        }
        int index=partition(array,left,right);
        quickSortHelp(array,left,index-1);
        quickSortHelp(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int beg=left;
        int end=right;
        int base=array[right];
        while (beg < end) {
            // 从左往右找到比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            // 当上面的循环结束时, beg 要么和 end 重合, 要么 beg 就指向一个大于 base 的值

            // 从右往左找比基准值小的元素, 初始情况下, end = right. array[end] 就和 base 相等.
            // 此时要把这个基准值就直接跳过. 始终保持基准值位置就在原位.
            while (beg < end && array[end] >= base) {
                end--;
            }
            // 当上面的循环结束之后, beg 要门和 end 重合, 要么 end 就指向一个小于 base 的值

            // 交换 beg 和 end 的值
            swap2(array, beg, end);
        }
        // 当 beg 和 end 重合的时候, 最后一步, 要把重合位置的元素和基准值进行交换
        // [思考] 为啥下面交换了之后, 仍然能满足快排的顺序要求呢?
        // right 这是一个序列中最后的位置. 就要求 beg end 重合位置的元素必须是大于等于基准值的元素, 才可以放到最后面.
        // 如何证明找到的  beg 位置的元素一定 >= 基准值呢?
        // a) beg++ 导致和 end 重合
        //    此时最终的值取决于上次循环中 end 指向的值. 上次循环中, end 应该是找到了一个小于基准值的元素, 然后和一个大于基准值的元素交换了.
        //    此处最终的 end 一定是大于基准值的元素
        // b) end-- 导致和 beg 重合
        //    此时上面 beg++ 的循环退出就一定是因为 beg 位置找到了一个比基准值大的元素, end 和 beg 重合最终元素也一定大于等于基准值.
        swap2(array, beg, right);
        return beg;
    }
    private static void swap2(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    //归并排序
    //归并排序借助的连个有序数组,之后合并为一个有序数组的做法,只是增加了递归.
    // 时间复杂度为o(n*long(n)).空间复杂度为o(n).
    //在if判断语句中增加一个=就是稳定排序.
    public static int[] Merge(int[] array){
        mergeSortHelper(array,0,array.length);
        return array;
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if(high-low<=1){
            return ;
        }
        int mid=(high+low)/2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid,high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0;  // 记录当前 output 数组中被放入多少个元素了
        int cur1 = low;
        int cur2 = mid;

        while (cur1 < mid && cur2 < high) {

            if (array[cur1] <=array[cur2]) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            } else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        // 当上面的循环结束的时候, 肯定是 cur1 或者 cur2 有一个先到达末尾, 另一个还剩下一些内容
        // 把剩下的内容都一股脑拷贝到 output 中
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }

        while (cur2 < high) {
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }

        // 把output中的元素再搬运回原来的数组
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr={2,5,1,6,9,3,10,9,23,12,4};
//        QuickSort(arr);
        System.out.println(Arrays.toString(Merge(arr)));
    }
}
