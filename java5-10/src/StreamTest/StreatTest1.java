package StreamTest;

import java.util.stream.Stream;

public class StreatTest1 {
    public static void main(String[] args) {
        //窃取stream中的元素
        String[] arr={"喜洋洋","美羊羊","懒洋洋","灰太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream1 = stream.limit(3);
        stream1.forEach(name-> System.out.println(name));


    }
}
