package LeetCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            ArrayList<String> list = new ArrayList<>();
            int n = sc.nextInt();
                for(int i=0;i<n;i++){
                    String str=sc.next();
                    String s=str.replaceAll("-","");

                    String result="";
                  for(char x : s.toCharArray()){
                      result+= number.charAt(symbol.indexOf(x));
                  }
                    result=result.substring(0,3)+"-"+result.substring(3);
                    if(!list.contains(result))
                        list.add(result);
                }
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }
}
