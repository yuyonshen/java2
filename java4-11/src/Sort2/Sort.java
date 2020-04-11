package Sort2;

public class Sort {
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length-1);
    }
    private static void quickSortHelper(int[] array, int left, int right){
        if(left>=right){
            return ;
        }
        int index=partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int start=left;
        int end=right;
        //基准元素
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
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr={6,5,2,7,4,9,8};
        quickSort(arr);
    }

}
