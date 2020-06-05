package Test;
class Base{
    public Base(String s){
        System.out.println("B");
    }
}



public class Derived extends Base {
    public Derived(String s) {
        super(s);
    }

    public static void main(String[] args) {
        new Derived("C");
    }
}
