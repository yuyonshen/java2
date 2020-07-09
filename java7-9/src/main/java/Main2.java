public class Main2 {
    public static int countNumberOf2s(int n) {
        int count = 0; // 最终 2 的个数
        int factor = 1; // 从低位到高位计算 2 的个数
        int low = 0; // 屏蔽掉低位
        int current = 0; // 当前计算位数的值
        int high = 0; // 计算高位
        while(n / factor != 0) {
            low = n - (n / factor) * factor;
            current = (n / factor) % 10;
            high = n / (factor * 10);
// 根据当前的
            switch (current) {
                case 0:
                case 1:
                    count += high * factor;
                    break;
                case 2:
                    count += high * factor + low + 1;
                    break;
                default:
                    count += (high + 1) * factor;
                    break;
            }
            factor *= 10;
        }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(125));
    }

}
