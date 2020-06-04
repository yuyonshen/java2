package threadTest;

import java.util.Arrays;

public class fond {
   private static int[] FildOut(int[] nums,int target){
       int left=0;
       int right=nums.length-1;
       int[] arr={-1,-1};
          for(int i=left;i<=right;i++){
              if(nums[i]==target){
                  arr[0]=i;
                  break;
              }
              left++;
          }
          for(int i=right;i>=left;i--){
              if(nums[i]==target){
                  arr[1]=i;
                  break;
              }
          }
       return arr;
   }

    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};

        System.out.println(Arrays.toString(FildOut(arr,8)));
    }
}
