package Sort;

import java.util.Arrays;

public class Sort {
    //插入排序
    public static void insertSort(int[] array){
        for(int bound=1;bound<array.length;bound++){
            int v=array[bound];
            int j=bound-1;
            for( ;j>=0;j--){
                if(v<array[j]){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=v;
        }
    }
    //选择排序
    public static void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    //希尔排序
    public static void shellSort(int[] array){
        int gap=array.length/2;
        while(gap>1){
            insertSortGap(array,gap);
            gap=gap/2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for(int i=1;i<array.length;i++){
            int v=array[i];
            int j=i-gap;
            for(;j>=0;j--){
                if(v<array[j]){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=v;
        }
    }
    //堆排序'
    public static void heapSort(int[] array){
        //首先建堆
        creatHeap(array);
        //循环取出堆顶元素
        for(int i=0;i<array.length;i++){
            //堆的有效长度
            int heapSize=array.length-i;
            swap(array,0,heapSize-1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    private static void swap(int[] array, int i, int i1) {
        int temp=array[i];
        array[i]=array[i1];
        array[i1]=temp;
    }

    private static void creatHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }

    }
    private  static void shiftDown(int[] array,int size,int index){
        int parent=index;
        int child=2*parent+1;
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

    //冒泡排序
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array={2,1,4,6,3,9,10};
       // insertSort(array);
        //selectSort(array);
        //shellSort(array);
        //heapSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
