package Stream2;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class StreamTest1<three> {

    /*
    使用传统的方法来实现
1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
5. 将两个队伍合并为一个队伍；存储到一个新集合中。
6. 根据姓名创建 Person 对象；存储到一个新集合中。
7. 打印整个队伍的Person对象信息。
     */
    public static void main(String[] args) {
//第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        List<String> one1 = new ArrayList<>();
        for (String s : one) {
            if (s.length() == 3) {
                one1.add(s);
            }
        }
        //第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        List<String> one2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one2.add(one1.get(i));
        }

//第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        //第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        List<String> two1 = new ArrayList<>();
        for (String s : two) {
            if (s.startsWith("张")) {
                two1.add(s);
            }
        }
        //第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        List<String> two2 = new ArrayList<>();
        for (int i = 2; i < two1.size(); i++) {
            two2.add(two1.get(i));
        }
        // 将两个队伍合并为一个队伍；存储到一个新集合中。
        List<String> three = new ArrayList<>();
        three.addAll(one2);
        three.addAll(two2);


        //根据姓名创建 Person 对象；存储到一个新集合中。
        ArrayList<Person> list = new ArrayList<>();
        for (String name : three) {
            list.add(new Person(name));
        }
        for(Person s : list){
            System.out.println(s);
        }
    }
}
