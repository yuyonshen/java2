package Hash;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String Actual=scanner.next();
            String Expectation=scanner.next();
            Actual=   Actual.toUpperCase();
            Expectation=   Expectation.toUpperCase();
            //现在创建set集合将Actual字符保存在set集合中
            Set<Character> set=new HashSet<>();
            for(char x : Expectation.toCharArray()){
                set.add(x);
            }
            Set<Character> set1=new HashSet<>();
            for(char x : Actual.toCharArray()){
                if(set.contains(x)){
                    continue;
                }
                if(set1.contains(x)){
                    continue;
                }
                System.out.print(x);
                set1.add(x);
            }
        }
    }
}
