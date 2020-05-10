package PrintAble;

public class PrintString {
    private static void printStrings(printable s){
        s.printa("helloWrod");
    }

    public static void main(String[] args) {
//        printStrings((String s)->{
//            System.out.println(s);
//        });
        printStrings(System.out::print);
    }
}
