package SortingTest;

import java.util.Arrays;
import java.util.concurrent.Exchanger;

public class Sorting {
    //插入排序
    public static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int v=array[i];
            int j=i-1;
            for(j=i-1;j>=0;j--){
                if(array[j]>v){
                    array[j+1]=array[j];
                }
//                array[j+1]=array[j];
            }
            array[j+1]=v;
        }
    }

    public static void main(String[] args) {
        int arr[]={2,4,6,1,7};
       // insertSort(arr);
        //bsInsertSort(arr);
        //BubbleSort(arr);
        ExchangeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //折半插入排序
    //前提条件这个数组是有序的
    public static void bsInsertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int v=array[i];
            int left=0;
            int right=i;

            while(left<right){
                int m=(left+right)/2;
                if(v>=array[m]){
                    left=m+1;
                }else{
                    right=m;
                }
            }
            for(int j=i;j>left;j--){
                array[j]=array[j-1];
            }
            array[left]=v;
        }
    }
    //冒泡排序
    public static void BubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>=1;j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }
    //交换排序
    public static void ExchangeSort(int[] array){
        for(int i=0;i<array.length-1;i++){

            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
    }
}
