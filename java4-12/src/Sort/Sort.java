package Sort;


import java.util.Arrays;

public class Sort {
    //插入排序
    public static void InsertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int value=array[i];
            int j=i-1;
            for(;j>=0;j--){
                if(value<array[j]){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=value;
        }

    }
    //希尔排序
    //希尔排序实质上也是一种优化的插入排序
    public static void HillSort(int[] array){
        int gap=array.length/2;
        while(gap>1){
            insertSortGap(array,gap);
            gap=gap/2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for(int i=1;i<array.length;i++){
            int value=array[i];
            int j=i-gap;
            for(;j>=0;j-=gap){
                if(value<array[j]){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=value;
        }

    }
    //选择排序
    public static void SelectSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    //堆排序
    public static void HeapSort(int[] array){
       //首先建堆,建成一个大堆
        creatHeap(array);
        for(int i=0;i<array.length-1;i++){
            //交换最后一个元素和堆顶元素
            int size=array.length-i;
            swop(array,0,size-1);
            size--;
            creatHeatTest(array,size,0);
        }
    }

    private static void creatHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
                creatHeatTest(array,array.length,i);

        }
    }

    private static void creatHeatTest(int[] array,int size, int index) {
        int parent=index;
        int child=index*2+1;
        while(child<size){
            if(child+1<size&&array[child+1]>array[child]){
                child=child+1;
            }
            if(array[index]<array[child]){
                swop(array,index,child);
            }else{
                break;
            }
           parent=child;
            child=parent*2+1;
        }
    }
    public static void swop(int[] array,int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    //冒泡排序
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                   swop(array,j,j-1);
                }
            }
        }
    }
    public static void main(String[] args) {

        int[] nums={5,1,3,7,9,4,8};
        //InsertionSort(nums);
        //HillSort(nums);
        //SelectSort(nums);
        //HeapSort(nums);
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
