import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class Dome2 {
    /**
     * 使用堆来进行升序排列数组
     */
    public static int[] HeapSort(int[] array){
        creatHeap(array);
        for(int i = 0; i < array.length; i++){
            int heapszie = array.length - i;
            swap(array, heapszie-1, 0);
            heapszie--;
            HeapHelper(array, heapszie, 0);

        }
        return array;
    }

    private static void swap(int[] array, int i, int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length-1-1)/2; i>=0 ;i--){
            HeapHelper(array, array.length, i);
        }
    }
    //向下调整
    private static void HeapHelper(int[] array, int size, int index) {
        int parent = index;
        int child = index*2 + 1;
        while(child < parent){
            if(child < parent && array[child] < array[child+1]){
                child = child+1;
            }
            if(array[parent] < array[child]){
                int temp = array[parent];
                array[parent] = array[child];
                array[child] = temp;
            }
            parent = child;
            child = parent*2 + 1;
        }
    }
}
