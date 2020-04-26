package Map_Set;

import sun.net.util.IPAddressUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //查找单词出现的最小次数
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res= new int[queries.length];
        int[] word=new int[words.length];
        for(int i=0;i<words.length;i++){
            word[i]= f(words[i]);
        }
        Arrays.sort(word);

        for(int i=0;i<res.length;i++){
            int a=f(queries[i]);
            int size=0;
            for(int j=0;j<word.length;j++){
                if(a<word[j]){
                    size++;
                }
            }
            res[i]=size;
            size=0;

        }
        return res;
    }

    private int f(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] arr=s.toCharArray();
        int size=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            size++;
            if(i<arr.length){
                if(arr[i]!=arr[i+1]){
                    break;
                }
            }
        }
        return size;
    }
    //判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    //
    //
    //	数字 1-9 在每一行只能出现一次。
    //	数字 1-9 在每一列只能出现一次。
    //	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

    public boolean isValidSudoku(char[][] board){
        Map<Integer, Integer>[] line=new HashMap[9];
        Map<Integer,Integer>[] column=new HashMap[9];
        Map<Integer,Integer>[] fong=new HashMap[9];
        for(int i=0;i<9;i++){
            line[i]=new HashMap<>();
            column[i]=new HashMap<>();
            fong[i]=new HashMap<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
               char num=(char)board[i][j];
                if(num!='.'){
                    int n=(int) num;
                    int box_index = (i / 3 ) * 3 + j / 3;
                    line[i].put(n,line[i].getOrDefault(n,0)+1);
                    column[i].put(n,column[i].getOrDefault(n,0)+1);
                    fong[box_index].put(n, fong[box_index].getOrDefault(n, 0) + 1);
                if(line[i].get(n)>1||column[i].get(n)>1||fong[i].get(n)>1){
                    return false;
                }
                }

            }

        }
        return true;
    }
}
