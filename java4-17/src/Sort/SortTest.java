package Sort;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class SortTest {
    //插入排序
    public static void InsertionSort(int[] array) {
        //将排序分为一排序序列.和为排序序列
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (num < array[j]) {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = num;
        }
    }

    //希尔排序
    public static void HillSort(int[] array) {
        //希尔排序也是基于插入排序为基础的
        int gap = array.length / 2;
        while (gap > 1) {
            helper(array, gap);
            gap = gap / 2;
        }
        helper(array, 1);
    }

    private static void helper(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int num = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (num < array[j]) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = num;
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        //在未排序的区间找到最大的一个值.之后插入在已排序区间的末尾
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //堆排序
    //首先堆排序是建立在建堆的基础上完成的,先建一个大堆,之后最后一个元素和对手元素交换
    public static void HeapSort(int[] array) {
        //首先建堆
        createrHeap(array);
        for (int i = 0; i < array.length - 1; i++) {

            int heapsize = array.length - i;

            swap(array, 0, heapsize - 1);

            heapsize--;

            helply(array, heapsize, 0);
        }
    }

    private static void swap(int[] array, int i, int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
    }

    private static void createrHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            helply(array, array.length, i);
        }
    }

    private static void helply(int[] array, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[index]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }

    }

    //冒泡排血,也是将区间划分为两个区间,一个数已排序区间,一个是为排序区间
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //快速排序(重点)一百在解决这个问题上我么能采用递归的形式来实现这个问题
    public static void QuickSort(int[] array) {
        QuickSortHelp(array, 0, array.length - 1);
    }

    private static void QuickSortHelp(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == right) {
            return;
        }
        int pos = helping(array, left, right);
        QuickSortHelp(array, left, pos - 1);
        QuickSortHelp(array, pos + 1, right);
    }

    private static int helping(int[] array, int left, int right) {
        int start = left;
        int end = right;
        int bag = array[right];
        while (start < end) {
            while (start < end && array[start] < bag) {
                start++;
            }
            while (start < end && array[end] >= bag) {
                end--;
            }
            swap(array, start, end);
        }
        swap(array, start, right);
        return start;
    }
//可是使用非递归的方式实现快去排序
    public static void QuickSort1(int[] array){
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left=stack.pop();
            int right=stack.pop();
            if(left>=right){
                continue;
            }
            int pos=helping(array,left,right);

            stack.push(pos-1);
            stack.push(left);

            stack.push(right);
            stack.push(pos+1);
        }
    }
    //归并排序
    //归并排序也是基于连个有序数组合并Wie一个有序数组
    public static void merge(int[] array,int low,int mid,int high){
        int out[]=new int[high-low];
        int cur1=low;
        int cur2=mid;
        int num=0;
        while(cur1<mid&&cur2<high){
            if(array[cur1]<=array[cur2]){
                out[num]=array[cur1];
                cur1++;
                num++;
            }else{
                out[num]=array[cur2];
                cur2++;
                num++;
            }
        }
        while(cur1<mid){
            out[num]=array[cur1];
            cur1++;
            num++;
        }
        while(cur2<high){
            out[num]=array[cur2];
            cur2++;
            num++;
        }
        for(int i=0;i<high-low;i++){
            array[low+i]=out[i];
        }
    }
    public static void mergeSort(int[] array){
        mergeSortHelp(array,0,array.length);
    }

    private static void mergeSortHelp(int[] array, int left, int right) {
        if(right-left<=1){
            return ;
        }
        int mid=(left+right)/2;

        mergeSortHelp(array,left,mid);

        mergeSortHelp(array,mid,right);

        merge(array,left,mid,right);
    }
//使用非递归的方式实现归并排序
    public static void mergeSort2(int[] array){
        for(int i=1;i<array.length;i*=2){
            for(int j=0;j<array.length;j+=i*2){
                int bag=j;
                int mid=i+j;
                int high=j+2*i;
               if(mid>array.length){
                  mid=array.length;
               }
               if(high>array.length){
                   high=array.length;
               }
                merge(array,bag,mid,high);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={5,3,6,8,2,1};
       // InsertionSort(arr);
        //HillSort(arr);
        //selectSort(arr);
        //HeapSort(arr);
       // bubbleSort(arr);
        //QuickSort(arr);
         //   QuickSort1(arr);
        //mergeSort(arr);
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
