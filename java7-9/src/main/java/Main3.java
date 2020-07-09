import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main3{
    public static void main(String[] args){
//        int n=10;
//        int m=2;
//        int num=10*30;
//        int result=0;
//        for(int i=0;i<30;i++){
//            result+=Math.pow(2,i);
//        }
//        System.out.println(num+"万"+" "+result+"分");

    }
   /*
         * 计算你能获得的最大收益
         *
         * @param prices Prices[i]即第i天的股价
         * @return 整型
         */
   public  int getmax(int [] prices ,int start ,int end )
   {
       int max = 0;
       int min = prices[start];
       for(int i=start+1;i<=end;i++)
       {
           if (prices[i]-min>max)
               max = prices[i]-min;
           if (prices[i]<min)
               min = prices[i];
       }
       return max ;
   }
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public  int calculateMax(int[] prices) {
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = getmax(prices, 0, i) + getmax(prices, i, prices.length - 1);
            if (temp > sum)
                sum = temp;
        }
        return sum;

    }
}
