import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    String[] mapString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> reslut = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        DFS(reslut, sb, digits, 0);
        return reslut;
    }

    private void DFS(List<String> reslut, StringBuffer sb, String digits, int i) {
        if(i == digits.length()){
            if(sb.length() != 0){
                reslut.add(sb.toString());
            }
            return;
        }
        int curmap = digits.charAt(i) - '0';
        String map = mapString[curmap];
        for(int k = 0; k < digits.length(); k++){
            DFS(reslut, sb.append(map.charAt(k)), digits, i+1);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}
