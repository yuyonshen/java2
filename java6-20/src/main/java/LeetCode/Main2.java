package LeetCode;
public class Main2 {
    public static void exchange(int n) {
        int a=0;
        int x = 2;
        for (int i = 0; i < 30; i++) {
            a +=n ;
        }
        System.out.println(a);
        int nums = 0;
        for (int i = 0; i < 30; i++) {
            nums += Math.pow(2, i);
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        exchange(10);
    }
}
