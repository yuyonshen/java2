package Thread;

public class synchronizedTest {
   //使用线程安全来实现一个买火车票系统
    public static void main(String[] args) {
        MyRunnbale my=new MyRunnbale();
        for(int i=0;i<10;i++){
          new Thread(my).start();
        }

    }

}
class MyRunnbale implements Runnable{
    Object o=new Object();
    int nums=100;
    @Override
    public void run() {
        while(true){
            synchronized (o){
                if(nums>0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+nums--);
                }
            }
        }
    }
}
