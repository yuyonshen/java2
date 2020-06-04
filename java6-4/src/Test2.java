public class Test2 {

   public int aMethed(){
       int i=0;
       i++;
       return i;

   }
    public static void main(String[] args) {
        Test2 test=new Test2();
        test.aMethed();
        int j=test.aMethed();
        System.out.println(j);
    }
}
