package Thread;

public class MyRunnbale implements Runnable {
    @Override
    public void run() {
        int i=0;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            System.out.println(i++);

    }
}
