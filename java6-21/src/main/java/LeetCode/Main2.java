package LeetCode;

import java.util.*;
public class Main2 {
    static int result = 0;

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            if (arr[i] == 0) {
//                int a = arr[i - 1];
//                int b = arr[i + 1];
//                heply(a, b);
//            }
//        }
//        System.out.println(result);
//    }
//
//    public static void heply(int a, int b) {
//        int d = Math.max(a, b);
//        for (int i = 0; i <= d; i++) {
//            if (a <= i && b <= i) {
//                result++;
//            }
//        }
//    }

    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] arr = new boolean[n];
        int a = 0;
        for(int i=0;i<n;i++){
            if(s.contains(p[i])){
                arr[i]=true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Main2 m=new Main2();
        String[] p={"a","b","c","d"};
        String s="abc";
        System.out.println( Arrays.toString( m.chkSubStr(p,4,s)));

    }
}

