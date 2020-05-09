package StreamTest;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class StreamTest2 {
    //所有的 Collection 集合都可以通过 stream 默认方法获取流
    //Stream 接口的静态方法 of 可以获取数组对应的流
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set=new HashSet<>();
        Stream<String> stream1 = set.stream();

        int[] arr={1,2,3,4,5,6};
        Stream<int[]> arr1 = Stream.of(arr);

        //根据map获取流
        Map<String,String> map=new HashMap<>();
        Stream<String> stream2 = map.keySet().stream();
        Stream<String> stream3 = map.values().stream();
        Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();

    }
}
