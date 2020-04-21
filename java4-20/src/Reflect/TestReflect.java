package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

//反射
class Animal{
    public void eat(String food){

    }
}
class Cat extends Animal{
    private String name;

    public Cat(String name) {
        this.name = name;
    }
    public Cat(){
        this.name="小猫";
    }
    public void eat(String food){
        System.out.println(this.name+" 正在吃 "+food);
    }
}
class Bird extends Animal{
    private String name ;

    public Bird(String name) {
        this.name = name;
    }
    public Bird(){
        this.name="小鸟";
    }
    public void eat(String food){
        System.out.println(this.name+" 正在吃 "+food);
    }
}
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
       //根据类的全限定名来获取类对象
        Class catclass=Class.forName("Reflect.Cat");
        //通过实例来获取类对象
        Cat cat=new Cat("小猫");
        Class catclass2=cat.getClass();
        System.out.println(catclass==catclass2);
       //透过类来获取类对象
        Class catclass3=Cat.class;
        //通过类对象来创建实例
        Scanner scanner=new Scanner(System.in);
        String classname=scanner.next();
        System.out.println("要创建的实例类型为"+classname);
        Class animalCat=Class.forName(classname);
        Animal animal=(Animal) animalCat.newInstance();
        animal.eat("鱼");
        //通过反射可以修改属性包括private修饰的属性
        Class classcat=Class.forName("Reflect.Cat");
        Field field=classcat.getDeclaredField("name");
        field.setAccessible(true);
        Cat cat2=new Cat();
        field.set(cat2,"小黑");
        String name =(String)field.get(cat);
        System.out.println(name);
        //通过反射获取类的方法
        Class catclass4=Class.forName("Reflect.Cat");
        Method method=catclass4.getMethod("eat",String.class,String.class);
        Cat cat3=new Cat();
        method.invoke("猫粮");
        //通过反射获取构造方法
        Class catclass5=Class.forName("Reflect.Cat");
        Constructor constructor=catclass5.getConstructor(String.class,String .class);
        Cat cat4=(Cat)constructor.newInstance("小黑");
        cat.eat("鱼");

    }

}
