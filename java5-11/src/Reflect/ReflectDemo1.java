package Reflect;

import Reflect1.Person;

public class ReflectDemo1 {
    /**
     获取Class对象的方式：
     1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     2. 类名.class：通过类名的属性class获取
     3. 对象.getClass()：getClass()方法在Object类中定义着。

     */
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName:将字节码文件加载进内存,返回Class对象.
        Class cla = Class.forName("Reflect1.Person");
        System.out.println(cla);
        //2.类名.class:通过类名的属性class获取.
        Class cla2 = Person.class;
        System.out.println(cla2);
        //3.对象.getClass():getClass()方法在Object类中定义的.
        Person p=new Person();
        Class cla3  = p.getClass();
        System.out.println(cla3);
    }
}
