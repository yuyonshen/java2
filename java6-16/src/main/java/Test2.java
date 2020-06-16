public class Test2 {
    public void add(Byte b){
        b=b++;
    }
    public void test(){
        Byte a=127;
        Byte b=127;
        add(++a);
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        Test2 t=new Test2();
        t.test();
    }
}
