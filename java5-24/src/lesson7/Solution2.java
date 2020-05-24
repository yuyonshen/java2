package lesson7;

public class Solution2 {
    public static void main(String[] args) {
        //test2();
        print();
    }
    private static void test2(){
        Thread t=new Thread(new test("A",null));
        Thread t2=new Thread(new test("B",t));
        Thread t3=new Thread(new test("C",t2));
        t.start();
        t2.start();
        t3.start();

    }
    private static class test implements Runnable{
        private String count;
        private Thread t;


        public test(String count, Thread t) {
            this.count = count;
            this.t = t;
        }

        @Override
        public void run() {
          if(t!=null){
              try {
                  t.join();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
           System.out.println(count);
        }
    }
    public static void print(){
        Thread t=new Thread(new test3("A"));
        Thread t2=new Thread(new test3("B"));
        Thread t3=new Thread(new test3("C"));
        t.start();
        t2.start();
        t3.start();
    }
    private static class test3 implements Runnable{
        private String count;
       private   String[] arr={"A","B","C"};
       private static int index;
        public test3(String count) {
            this.count = count;
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                synchronized (test3.class){
                    while(!count.equals(arr[index])){
                        try {
                            test3.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(arr[index]);
                    index=(index+1)%arr.length;
                    test3.class.notifyAll();
                }
            }
        }
    }
}




