package OI_study;

import org.junit.After;

public class Animal  {
     public  void fly(){
         System.out.println("动物");
     }
}

class bild extends Animal{
    public void fly(){
        System.out.println("小鸟正在飞");
    }
}
class grid extends bild{
    public void fly(){
        System.out.println("小计正在飞");
    }
}
class Main{
    public static void main(String[] args) {
        Animal a1=new Animal();
        a1.fly();
        Animal a2=new bild();
        a2.fly();
        Animal a3=new grid();
        a3.fly();
    }
}