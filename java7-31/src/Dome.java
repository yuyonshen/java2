import com.mysql.jdbc.SocketMetadata;
import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class Dome {
    /**
     * 使用快速排序来进行给数组排序
     * @param array
     */
    public static void QuickSort(int[] array) {
    QucikSortHelper(array, 0, array.length-1);
    }

    private static void QucikSortHelper(int[] array, int start, int end) {
        if(start >= end){
            return;
        }
        int index = Helper(array, start, end);
        QucikSortHelper(array, start, index-1);
        QucikSortHelper(array, index+1, end);
    }

    private static int Helper(int[] array, int start, int end) {
        int left =start;
        int right = end;
        int a = array[end];
        while(start < end){
            while(left < right && array[left] <= a){
                left++;
            }
            while(left < right && array[right] >= a){
                right--;
            }
            swap(array, left, right);
        }
        swap(array, left, end);
        return left;
    }

    private static void swap(int[] array, int start, int end) {
            int temp = array[start];
            array[start] = array[end];
            array[end ] = temp;
    }

}
