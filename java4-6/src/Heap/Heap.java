package Heap;

import java.util.Arrays;

public class Heap {
    public static void shiftDown(int[] arr,int size,int index){
        int parent=index;
        int left=index*2+1;
        while(left<size){

            if(left+1<size&&arr[left]>arr[left+1]){
                left=left+1;
            }
            if(arr[parent]<arr[left]){
                break;
            }else{
                int temp=arr[parent];
                arr[parent]=arr[left];
                arr[left]=temp;
            }
            parent=left;
            left=parent*2+1;
        }
    }
    public static void createHeap(int arr[] ,int size){
        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(arr,size,i);
        }
    }

    public static void main(String[] args) {
        int[] arr={27,15,19,18,28,34,65,49,25,37};
        createHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
