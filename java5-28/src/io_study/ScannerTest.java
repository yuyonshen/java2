package io_study;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //假如,接收的输入为:
        //4
        //3 1 10 31
        while (sc.hasNextInt()) {
            int num = sc.nextInt();//读取到IO数据直到瞒住条件,否则堵塞等待
            for (int i = 0; i < num; i++) {
                int data = sc.nextInt();
                System.out.println(data);
            }
        }
        while (sc.hasNextInt()) {
           String s=sc.nextLine();//读取到IO数据直到瞒住条件,否则堵塞等待
            for (int i = 0; i < s.length(); i++) {
                int data = sc.nextInt();
                System.out.println(data);
            }
        }
    }
}
