package StreamTest;

import java.util.stream.Stream;

public class SteatTest2 {
    public static void main(String[] args) {
        //舍去前面的元素
        String[] arr={"喜洋洋","美羊羊","懒洋洋","灰太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream2 = stream.skip(3);
        stream2.forEach((String name)->{
            System.out.println(name);
        });
    }
}
