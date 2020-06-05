package Test;

public class Person {
    public String name = "Person";
    int age=0;
}
class Child extends Person {
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        System.out.println(p.name);
    }
}
