import sun.reflect.generics.repository.MethodRepository;

public class Solution3 {
    /**
     * 归并排序
     * @param array
     * @return
     */
    public static int[] Merge(int[] array){
        MergeHelper(array, 0, array.length);
        return array;
    }

    private static void MergeHelper(int[] array, int left , int right) {
        if((right - left) <= 1 ){
            return ;
        }
        int mid = (left + right)/2;
        MergeHelper(array, left, mid);
        MergeHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] higt = new int[right - left];
        int index = 0;
        int cur = left;
        int cur2 = mid;
        while(cur < mid && cur2 < right){
            if(array[cur] > array[cur2]){
                higt[index] = array[cur2];
                cur2++;
                index++;
            }else{
                higt[index] = array[cur];
                cur++;
                index++;
            }
        }
        if(cur < mid){
            higt[index] = array[cur];
            cur++;
            index++;
        }
        if(cur2 < right){
            higt[index] = array[cur2];
            cur2++;
            index++;
        }
        for(int i = 0; i < higt.length; i++){
            array[left+i] = array[i];
        }
    }
}
