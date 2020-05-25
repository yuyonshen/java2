package lesson8;

public class ThreadTest2 {
    /**
     * 升级版要求：
     * （1）同时执行
     * （2）打印结果：
     * ABC
     * ABC
     * 循环打印共计10次
     * 思路：
     * 每个线程循环10次来打印A、B、C
     * 每次打印之后，等待其余线程打印完，再往下执行
     */
    public static void main(String[] args) {
        print2();
    }
    private static void print2(){
        Thread t1=new Thread(new Print("A"));
        Thread t2=new Thread(new Print("B"));
        Thread t3=new Thread(new Print("C"));
        t1.start();
        t2.start();
        t3.start();
    }
    private static class Print implements Runnable{
        private static String[] arr={"A","B","C"};
        private String count;
        private  static int index;

        public Print(String count) {
            this.count = count;
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                synchronized (arr){
                    while(!count.equals(arr[index])){
                        try {
                            arr.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(arr[index]);
                    if(index==arr.length-1){
                        System.out.println();
                    }
                    index=(index+1)%arr.length;
                    arr.notifyAll();
                }

            }
        }
    }
}
