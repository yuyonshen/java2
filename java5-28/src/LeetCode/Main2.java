package LeetCode;

import java.util.Scanner;

public class Main2 {
    /*
    每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = "NESW";
        int l = 0;
        String s = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                l++;
            } else {
                l--;
            }
        }
        l %= 4;
        if (l < 0) {
            l = l + 4;
        }
        System.out.println(str.charAt(l));
    }
}
