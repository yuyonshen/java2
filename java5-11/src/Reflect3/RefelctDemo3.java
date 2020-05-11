package Reflect3;

import Reflect1.Person;

import java.io.File;
import java.lang.reflect.Field;

public class RefelctDemo3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         Class对象功能：
         * 获取功能：
         1. 获取成员变量们
         * Field[] getFields()
         * Field getField(String name)

         * Field[] getDeclaredFields()
         * Field getDeclaredField(String name)
         2. 获取构造方法们
         * Constructor<?>[] getConstructors()
         * Constructor<T> getConstructor(类<?>... parameterTypes)

         * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         * Constructor<?>[] getDeclaredConstructors()
         3. 获取成员方法们：
         * Method[] getMethods()
         * Method getMethod(String name, 类<?>... parameterTypes)

         * Method[] getDeclaredMethods()
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

         4. 获取类名
         * String getName()



         */
        /*
        1. 获取成员变量们
         * Field[] getFields()//只能获取public 修饰的成员
         * Field getField(String name)

         * Field[] getDeclaredFields()
         * Field getDeclaredField(String name)
         */
        Class p = Person.class;
        Field[] fields = p.getFields();
        for(Field  x : fields){
            System.out.println(x);
        }
        System.out.println("-------------");
        Field a = p.getField("a");
        //之后在获取a的值
        Person person=new Person();
        Object obj = a.get(person);
        System.out.println(obj);
        //设置a的值
         a.set(person, "张三");
        System.out.println(person);


        System.out.println("=================");
        //Field[] getDeclaredFields() 获取所有成员变量,不考虑修饰符
        Field[] declaredFields = p.getDeclaredFields();
        for(Field x : declaredFields){
            System.out.println(x);
        }
        //Field getDeclaredField(String name)
        Field b = p.getDeclaredField("name");
        //或略访问权限修饰的的安全检查.
        b.setAccessible(true);//暴力反射
        Object o = b.get(person);
        System.out.println(o);
    }
}
