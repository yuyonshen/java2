package StreamTest;

import java.util.stream.Stream;

public class StreamTest3 {
    //延迟方法：返回值类型仍然是 Stream 接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方 法均为延迟方法。）
    // 终结方法：返回值类型不再是 Stream 接口自身类型的方法，因此不再支持类似 StringBuilder 那样的链式调 用。本小节中，终结方法包括 count 和 forEach 方法。
    public static void main(String[] args) {
        Stream<String> stream= Stream.of("张三", "于晓", "小明", "花花");
        stream.forEach((String name)->{
            System.out.println(name);
        });
    }
}
