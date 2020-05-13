package ProgrammingProblem;

public class StackTest implements  StackInterface {
    private int top=0;
    private int[] arr=new int[10];
    private boolean udgement=false;

    @Override
    public void push(int n)  {
        synchronized (this){
            while(udgement) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                arr[top]=n;
                System.out.println("压入数字"+n+"完成");
                top++;
                udgement=true;
                notifyAll();
                System.out.println("压入完成");
            }

    }
    public int[] pop(){
        synchronized (this){
            while(!udgement){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("弹出");
            top--;
            int[] test={arr[top],top};
            udgement=false;
            notifyAll();
            return test;
        }
    }
}
