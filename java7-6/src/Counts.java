public class Counts {
    static int count=0;
    static int a=0;
    public static int countNumberOf2s(int n) {
        for (int i = 0; i <= n; i++) {
            String s = Integer.toString(i);
            for (char x : s.toCharArray()) {
                if (x == '2') {
                    count++;
                }
            }

        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countNumberOf2s(200));
    }
}
