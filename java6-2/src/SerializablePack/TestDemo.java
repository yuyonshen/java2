package SerializablePack;

import java.io.*;

public class TestDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializePerson();
        deserializePreason();
    }
    //首先对Person进行序列化
    private static void serializePerson() throws IOException {
        Person p=new Person();
        p.setName("余振晗");
        p.setAge(23);
        p.setSex("男");
        p.setStuId(120);
        //创建输出流对象
        FileOutputStream fos=new FileOutputStream("E:\\图片\\3.txt");
        //创建对象输出流
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        //对对象系列化输出值指定文件中.
        oos.writeObject(p);
        System.out.println("对象序列化成功");
        oos.close();


    }

    private static Person deserializePreason() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("E:\\图片\\3.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Person p = (Person) ois.readObject();
        System.out.println("反序列化成功");
        System.out.println(p);
        return p;
    }
}
