package Thread2;

public class main {
    public static void main(String[] args) {
        interruptTest2 in = new interruptTest2();
        Thread t = new Thread(in, "李四");
        t.start();
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"老板来电话了,这个人是骗子");
        t.isInterrupted();

    }
}
