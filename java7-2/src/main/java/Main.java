import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> lista=list;
        lista.set(1,1);
        System.out.println(list.get(1));
    }
}
