package StreamTest;

import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        /*此前我们已经学习过 java.util.stream.Predicate 函数式接口，其中唯一的抽象方法为：
        boolean teat(T t);
        该方法将会产生一个boolean值结果，代表指定的条件是否满足。
        如果结果为true，那么Stream流的 filter 方法 将会留用元素；
        如果结果为false，那么 filter 方法将会舍弃元素。
 */
        Stream<String> stream = Stream.of("张三丰", "张无忌", "小明");
        Stream<String> stream2 = stream.filter((String name) -> {
            return name.startsWith("张");
        });
        stream2.forEach((String name)->{
            System.out.println(name);
        });

    }

}
