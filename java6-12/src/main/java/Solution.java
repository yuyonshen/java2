import java.util.*;
public class Solution {
    public int[] multiply(int[] A) {
        if(A==null&&A.length==0){
            return A;
        }
        int[] B=new int[A.length];
        for(int i=0;i<A.length;i++){
            int num=1;
            for(int j=0;j<B.length;j++){
                if(i!=j){
                    num*=A[j];
                }
            }
            B[i]=num;
        }
        return B;
    }
}
