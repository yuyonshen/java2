import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> list=new ArrayList<>();
        int len_word=words[0].length();
        int len=len_word*words.length;
        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(int i=0;i<(s.length()-len+1);i++){
            String a=s.substring(i,len+i);
            Map<String ,Integer> map1=new HashMap<>();
            for(int j=0;i<len;i+=len_word){
                String w=a.substring(j,j+len_word);
                map1.put(w,map1.getOrDefault(w,0)+1);
            }
            if(map.equals(map1)){
                list.add(i);
            }
        }
        return list;
    }
}
