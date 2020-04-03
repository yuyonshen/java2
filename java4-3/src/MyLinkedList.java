
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {

    public void getList(String str){
        List list=new LinkedList();
        int num=0;
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (c == '+' && i < str.length()) {
                list.add(str.charAt(i + 1) + " ");
                num++;
            } else if (c == '-') {
                if (list.size() > 0) {
                    System.out.println(list.get(num-1));
                    list.remove(num-1);
                    num--;
                }
            }
        }
                System.out.println("最后结果:");
                if(list.size()==0){
                    System.out.println("空");
                }
                for(int j=0;j<list.size();j++){
                    System.out.println(list.get(j));
                }
    }

    public static void main(String[] args) {
        new MyLinkedList().getList("+U+n+c-+e+r+t-+a-+i-+n+t+y-+-+r+u-+l+e+s--");
    }
}
