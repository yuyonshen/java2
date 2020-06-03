package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        List<Character> list=new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('F');
        list.remove(2);
        System.out.println(list);

    }
}
