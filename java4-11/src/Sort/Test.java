package Sort;

import java.util.Arrays;

public class Test {
    //归并排序
    //归并排序的金典问题是:将两个有序数组,合并生一个有序数组
    public static void merge(int[] array,int low,int mid,int high){
        //首先创建一个临时数组
        int[] arr=new int[high-low];
        int num=0;  //用来保存数组中元素的个数
        int cur1=low;
        int cur2=mid;
        while(cur1<mid&&cur2<high){
            if(array[cur1]<array[cur2]){
                arr[num]=array[cur1];
                cur1++;
                num++;
            }else{
                arr[num]=array[cur2];
                cur2++;
                num++;
            }
        }
        while(cur1<mid){
            arr[num]=array[cur1];
            cur1++;
            num++;
        }
        while(cur2<high){
            arr[num]=array[cur2];
            cur2++;
            num++;
        }
        for(int i=0;i<high-low;i++){
            array[low+i]=arr[i];
        }
    }
    private static void mergeSortHelper(int[] array, int low, int high){
        if(high-low<=1){
            return ;
        }
        int mid=(high+low)/2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid,high);
        merge(array,low,mid,high);
    }
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //mergeSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    //使用非递归的方式进行归并排序
    public static void mergeSortByLoop(int[] array){
        //引入一个变量进行分组
        for(int gap=1;gap<array.length;gap*=2){
            for(int i=0;i<array.length;i+=2*gap){
                int low=i;
                int mid=i+gap;
                int high=i+2*gap;
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
}
