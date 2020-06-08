import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String str = in.nextLine();
//            String[] strs = str.split(" ");
//            int[] arr = new int[strs.length];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = Integer.valueOf(strs[i]);
//            }
       //     int[] arr = new int[strs.length];
           int[] arr={3, 9, 3 ,2 ,5 ,6 ,7 ,3 ,2 ,3 ,3 ,3};
            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                } else if (count > 0) {
                    count--;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
//    }
}