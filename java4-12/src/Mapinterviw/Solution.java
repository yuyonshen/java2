package Mapinterviw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            Integer value=map.get(x);
            if(value==null){
                map.put(x,1);
            }else{
                map.put(x,1+value);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }
    //还可以使用按位异或运算
    //a^b^b=a;按照这个原理来实现这个操作

    public int singleNumber2(int[] nums){
        int ret=0;
        for(int x:nums){
            ret^=x;
        }
        return ret;
    }

    public int[] singleNumber3(int[] nums) {
        int ret=0;
        for(int x : nums){
            ret^=x;
        }
        int bit=1;
        int i=0;
        for(;i<32;i++){
            if((ret&(bit<<i))!=0){
                break;
            }
        }
        int a=0;
        int b=0;
        for(int x : nums){
            if((x&(bit<<i))!=0){
                a^=x;
            }else{
                b^=x;
            }
        }
        int[] arr={a,b};
        return arr;
    }
    //使用键值对完成这个操作
    public int[] singleNumber4(int[] nums){
        Map<Integer, Integer> map=new HashMap<>();
        for(int x : nums){
            Integer value=map.get(x);
            if(value==null){
                map.put(x,1);
            }else{
                map.put(x,value+1);
            }
        }
        int[] arr=new int[2];
        int i=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue().equals(1)){
                arr[i]=entry.getKey();
                i++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Solution sn=new Solution();
        int[] arr={1,1,2,2,3,3,4};
        int result=sn.singleNumber(arr);
        System.out.println(result);
        int[] arr1={1,2,1,3,2,5};
        System.out.println(Arrays.toString(sn.singleNumber4(arr1)));
    }
    //石头和宝石之间的关系
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
//        int nums=0;
//        for(int i=0;i<J.length();i++){
//            char a=J.charAt(i);
//            for(int j=0;j<S.length();j++){
//                if(a==S.charAt(j)){
//                    nums++;
//                }
//            }
//        }
//        return nums;
//        }
        int a=0;
        for(int i=0;i<J.length();i++){


        for(int j=0;j<S.length();j++) {
            if(J.charAt(i)==S.charAt(j)){
                map.put(J.charAt(i),a+1);
                a++;
            }

        }}
        return a;
    }

}
