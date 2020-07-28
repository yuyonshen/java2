import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution4 {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> reslut = new ArrayList<>();
       if(str.length() > 0 && str != null){
           PermutationHelper(str.toCharArray(), 0, reslut);
           Collections.sort(reslut);
       }
        return reslut;
    }

    private void PermutationHelper(char[] str, int start, ArrayList<String> reslut) {
        if(start == str.length-1){
            if(!IsEXst(reslut, str)) {
                reslut.add(new String(str));
            }
            return ;
        }
        for(int i = 0; i < str.length; i++){
            swap(str, i, start);
            PermutationHelper(str, start+1, reslut);
            swap(str, i, start);
        }
    }

    private boolean IsEXst(ArrayList<String> reslut, char[] str) {
        return reslut.contains(new String(str));
    }

    private void swap(char[] str, int i, int start) {
        char temp = str[i];
        str[i] = str[start];
        str[start] = temp;
    }
}
