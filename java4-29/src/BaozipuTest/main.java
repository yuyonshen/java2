package BaozipuTest;

public class main {
    public static void main(String[] args) {
        baozipu bp=new baozipu();
        new chihou(bp).start();
        new laoban(bp).start();
    }
}
