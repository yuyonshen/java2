package StreamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        /*
        正如旧集合 Collection 当中的 size 方法一样，流提供 count 方法来数一数其中的元素个数：
        long counyt();

         */
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }

}
