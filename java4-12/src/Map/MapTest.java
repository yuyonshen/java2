package Map;

import java.util.*;

public class MapTest {
    //HashMap 哈希表中的键值对.
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //首先操作的是向map中增加元素
        map.put(1, "hello");
        map.put(2, "java");
        map.put(3, "bit");
        System.out.println(map);
        //根据key获取value
        System.out.println("=============");
        System.out.println(map.get(1));
        System.out.println(map.getOrDefault(4, "haha"));
        //打印所有的key
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        //打印所有的value
        for (String value : map.values()) {
            System.out.println(value);
        }
        //按照一一对应的关系打印出键值对
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        //Set的使用
        //首先咋HashSet中存放的是单个元素
        Set<String> set = new HashSet<>();
        //向集合中增加元素
        set.add("hello");
        set.add("word");
        set.add("java");
        System.out.println(set);
        //判断元素是否在集合中
        System.out.println(set.contains("heihei"));
        //使用迭代器遍历集合
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    //打印只出现一次的数字
}
