package Stream2;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public Person(){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
