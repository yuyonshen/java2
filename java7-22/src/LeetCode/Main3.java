package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    static List<ArrayList<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            dps(1,n,m);
            for(ArrayList<Integer> l : res){
                for(int i = 0; i < l.size(); i++){
                    System.out.print(l.get(i)+" ");
                }
                System.out.println();
            }
        }
    }

    private static void dps(int index, int n, int m) {
        if(m==0){
        res.add(new ArrayList<>(list));
        }else{
            for(int i = index; i <= m && i <= n; i++) {
                list.add(i);
                dps(i + 1, n, m - i);
                list.remove(list.size() - 1);
            }
        }
    }
}
