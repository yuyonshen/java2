

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(i);
            }

            while (queue.size() != 1) {
                int count = 0;
                while (count != 2) {
                    int a = queue.poll();
                    queue.offer(a);
                    count++;
                }
                queue.poll();
            }
            System.out.println(queue.poll());
        }
    }
}
