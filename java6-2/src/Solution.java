import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0){
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            List<Integer> upper=result.get(i-1);
            row.add(1);
            for(int j=1;j<numRows;j++){
                row.add(upper.get(j-1)+upper.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
