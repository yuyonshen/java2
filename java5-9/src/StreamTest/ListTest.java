package StreamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListTest {
    //简历一个集合堆集合过滤
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张三");
        list.add("小明");
        list.add("张无忌");
        list.add("张三愚");
        list.add("张飞");
//        for(String name : list){
//            System.out.println(name);
//        }
//        //堆姓为长得进行筛选
//        List<String> listA=new ArrayList<>();
//        for(String name : list){
//            if(name.startsWith("张")){
//                listA.add(name);
//            }
//        }
//        //对listA集合中姓名长度为3进行筛选
//        List<String> listB = new ArrayList<>();
//        for(String name : listA){
//            if(name.length()==3){
//                listB.add(name);
//            }
//        }
//        //遍历集合listB
//        for(String name : listB){
//            System.out.println(name);
//        }
        //这只是普通的方法进行筛选.我么那可以使用Stream流进行筛选
       list.stream().filter(name->name.startsWith("张"))
                    .filter(name->name.length()==3)
                    .forEach(name-> System.out.println(name));

    }

}
