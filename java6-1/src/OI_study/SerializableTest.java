package OI_study;

import com.sun.corba.se.impl.encoding.CodeSetConversion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableTest implements Serializable {
    private String name;
    private List<Food> list=new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableTest t = new SerializableTest();
        t.name = "快餐店";
        t.list.add(new Food("咖啡"));
        t.list.add(new Food("牛排"));
        t.list.add(new Food("小龙虾"));
        ByteArrayOutputStream bytes=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(bytes);
        objectOutputStream.writeObject(t);
        t.name="慢点吃";
        t.list.get(1).name="猪肉";
        ByteArrayInputStream by=new ByteArrayInputStream(bytes.toByteArray());
        ObjectInputStream ob=new ObjectInputStream(by);
        SerializableTest t2= (SerializableTest) ob.readObject();
        System.out.println(t);
        System.out.println(t2);



    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    private static class Food implements Serializable{
        private String name;

        public Food(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
