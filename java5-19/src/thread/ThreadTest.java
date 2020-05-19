package thread;

public class ThreadTest {
    private static class Counter{
        private int n1=0;
        private int n2=0;
        private int n3=0;
        private int n4=0;
        private int n5=0;
        private int n6=0;
        private int n7=0;
        private int n8=0;
        public void write(){
            n1=1;
            n2=2;
            n3=3;
            n4=4;
            n5=5;
            n6=6;
            n7=7;
            n8=8;
        }
        public void read(){
            System.out.println("n1="+n1);
            System.out.println("n2="+n2);
            System.out.println("n3="+n3);
            System.out.println("n4="+n4);
            System.out.println("n5="+n5);
            System.out.println("n6="+n6);
            System.out.println("n7="+n7);
            System.out.println("n8="+n8);
        }

    }

    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread t1=new Thread(()->{
            counter.read();
        },"读");
        Thread t2=new Thread(()->{
            counter.write();
        },"写");
        t1.start();
        t2.start();
    }
}
