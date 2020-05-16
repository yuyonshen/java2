package Thread;

public class threadTest2 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
