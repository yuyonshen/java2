package StreamTest;

import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        //将连个流合并为一个流
        Stream<String> streamA = Stream.of("美羊羊");
        Stream<String> streamB = Stream.of("喜洋洋");
        //调用Stream中搞得静态方法concat将两个流合并为一个流
        Stream<String> concat = Stream.concat(streamA, streamB);
        concat.forEach((String name)->{
            System.out.println(name);
        });
    }
}
