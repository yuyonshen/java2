
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            while (n > 0) {
                list.add(n % 10);
                n = n / 10;
            }
            Collections.sort(list);
            for (int x : list) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
