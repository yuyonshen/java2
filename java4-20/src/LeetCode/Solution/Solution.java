package LeetCode.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    //最常见的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph+=".";
        Set<String> set=new HashSet<>();
        for(String x : banned){
            set.add(x);
        }
        int num=0;
        String nums="";
        Map<String ,Integer> map=new HashMap<>();
        StringBuffer sb=new StringBuffer();
        for(char x : paragraph.toCharArray()){
            if(Character.isLetter(x)){
                sb.append(Character.toLowerCase(x));
            }else if(sb.length()>0){
                String st=sb.toString();
                if(!set.contains(st)){
                    map.put(st,map.getOrDefault(st,0)+1);
                if(map.get(st)>num){
                    nums=st;
                    num=map.get(st);
                }
                }
                sb=new StringBuffer();
            }

        }
        return nums;
    }
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }


}
