package StreamTest;

import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
        /*
        如果需要将流中的元素映射到另一个流中，可以使用 map 方法。方法签名：

         */
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<Integer> stream2 = stream1.map((String s) -> {
            return Integer.parseInt(s);
        });
        stream2.forEach((i)->{
            System.out.println(i);
        });
    }
}
