package SerializablePack;

import java.io.Serializable;

public class Person implements Serializable {
    private String name ;
    private int age;
    private String sex;
    private int stuId;

//    public Person(String name, int age, String sex, int stuId) {
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//        this.stuId = stuId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", stuId=" + stuId +
                '}';
    }
}
