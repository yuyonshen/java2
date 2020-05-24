package lesson7;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        s.Threadtest();
    }

    public void Threadtest() throws InterruptedException {
        char[] arr = {'A', 'B', 'C'};
        Thread t1 = new Thread(() -> {
            System.out.println(arr[0]);
        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(() -> {
            System.out.println(arr[1]);
        });
        t2.start();
        t2.join();
        Thread t3 = new Thread(() -> {
            System.out.println(arr[2]);
        });
        t3.start();
        t3.join();
    }

}
