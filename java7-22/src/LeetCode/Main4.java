package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] str = s.split("\\\\");
            String name = str[str.length-1]+" "+sc.next();
            int index = list.indexOf(name);
            if(index != -1){
                list2.set(index,list2.get(index)+1);
            }else{
                list.add(name);
                list2.add(1);
            }
        }
        String[] str1 = new String[list.size()];
        
        String[] str2 = new String[list2.size()];

    }
}
