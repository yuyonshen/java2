import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String reslut = new String();
       if(numbers == null){
           return new String();
       }
       ArrayList<Integer> list = new ArrayList<>();
       for(int x : numbers){
           list.add(x);
       }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String xy = o1+""+02;
                String yx = o2+""+o1;
                return xy.compareTo(yx);
            }
        });
       for(int x : list){
           reslut += x;
       }
       return reslut;
    }
}