import threadTest.Foo;

public class SequencePrint {
    private static void Print(){
        Foo f=new Foo();
        try {
            Thread t1=new Thread(()->{
                f.one();
            });
            t1.start();
            t1.join();
            Thread t2=new Thread(()->{
                f.two();
            });
            t2.start();
            t2.join();
            Thread t3=new Thread(()->{
                f.three();
            });
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Print();
    }
}
