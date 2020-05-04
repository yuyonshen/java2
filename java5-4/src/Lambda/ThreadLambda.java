package Lambda;

public class ThreadLambda {
    public static void main(String[] args) {

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"创建一个线程");
            }
        }).start();

        //使用lambda表达式来简化代码

        new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"创建一个线程");
            }
        ).start();
    }
}
