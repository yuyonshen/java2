package Reflect1;

public class Person {
    private String name;
    private String age;

    public String a;
    public String b;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}

