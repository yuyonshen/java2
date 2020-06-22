package LeetCode;

import javax.imageio.stream.ImageInputStream;

public class Main {

        public static int getValue(int[] gifts, int n) {
            int index=0;
            for(int i=0;i<n-1;i++){
                if(gifts[i]==gifts[i+1]){
                    index++;
                }else if(index>0){
                    index--;
                }else{
                    index=0;
                }
            }
            if(index==0){
                return 0;
            }else{
                return gifts[index];
            }

        }

    public static void main(String[] args) {
        int[] arr={1,2,2,3,2};
        System.out.println(getValue(arr,5));

    }
}
