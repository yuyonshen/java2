package BaozipuTest;

public class laoban extends Thread {
   private baozipu bz;
    public laoban(baozipu bz){
        this.bz=bz;
    }
    int cunt=0;
    @Override
    public void run() {
        while(true){
        synchronized (bz) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (bz.flag == true) {
                try {
                    bz.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("包子铺开始做包子");
            if (cunt % 2 == 0) {
                bz.xian = "肉";
                bz.pi = "薄";

            } else {
                bz.xian = "蔬菜";
                bz.pi = "厚";
            }
            cunt++;
            bz.flag = true;
            System.out.println("包子造好了" + bz.pi + bz.xian + "的包子");
            System.out.println("可以吃包子了");
            bz.notify();
        }
        }
    }
}
