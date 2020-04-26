package Examination;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(java.lang.String[] args){
        Set<String> set =new HashSet<>();
        Scanner scanner=new Scanner(System.in);
       while(scanner.hasNext()){
           String sb=scanner.next();
           String[] arr=sb.split(" ");
            for(int i=0;i<arr.length;i++) {
                set.add(arr[i]);
            }

       }
        System.out.println(set.size());
    }
}
