package BaozipuTest;

public class chihou extends Thread {
    private baozipu bz;

    public chihou(baozipu bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while(true){
        synchronized (bz) {
            if (bz.flag == false) {
                try {
                    bz.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("吃货正在吃" + bz.pi + bz.xian + "的包子");
            bz.flag = false;
            bz.notify();
        }
        }

    }
}
