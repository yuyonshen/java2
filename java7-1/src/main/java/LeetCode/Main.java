package LeetCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        help(arr,array);
    }

    private static void help(int[] arr, int[] array) {
        int nums=0;
        for(int i=0;i<arr.length;i++){
            nums+=arr[i];
        }
        double index=0;
        for(int i=0;i<array.length;i++){
           double a=pointOfEachCourse(array[i]);
           index+=a*arr[i];
        }
        System.out.printf("%.2f",index/nums);
    }

    private static double pointOfEachCourse(int garp) {
        double num = 0;
        if (garp <= 100 && garp >= 90) {
            num = 4.0;
        } else if (garp >= 85 && garp <= 89) {
            num = 3.7;
        } else if (garp >= 82 && garp <= 84) {
            num = 3.3;
        } else if (garp >= 78 && garp <= 81) {
            num = 3.0;
        } else if (garp >= 75 && garp <= 77) {
            num = 2.7;
        } else if (garp >= 72 && garp <= 74) {
            num = 2.3;
        } else if (garp >= 68 && garp <= 71) {
            num = 2.0;
        } else if (garp >= 64 && garp <= 67) {
            num = 1.5;
        } else if (garp >= 60 && garp <= 63) {
            num = 1.0;
        } else {
            num = 0;
        }
        return num;

    }
}
