package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 解法一：模拟洗牌法
 * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
 * 新建一个ArrayList,先加入1，然后4，接着依次加入 2 ， 5 ， 3 ， 6
 * 于是1,4,2,5,3,6，这就完成了一次洗牌的过程
 * k次洗牌，就把上述过程重复k次。
 * 优点： 直观易懂，模拟题中的洗牌过程。
 * 缺点： 大量运用arrayList 和数组的数字转移，且for循环次数过多，繁琐
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i ++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < 2 * n; j ++) {
                arr[j] = sc.nextInt();
            }
            for (int times = 0; times < k; times ++) {
                ShuffleOnce(arr, arr.length);
            }
            for (int a = 0; a < n * 2 - 1; a ++) {
                System.out.print(arr[a] + " ");
            }
            System.out.println(arr[n * 2 - 1]);
        }
    }

    private static void ShuffleOnce(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n / 2; i ++) {
            list.add(arr[i]);
            list.add(arr[i + n / 2]);
        }
        for (int i = 0; i < n; i ++) {
            arr[i] = list.get(i);
        }
    }
}

