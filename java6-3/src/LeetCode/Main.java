package LeetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        int index=0;
//        int add=0;
//        List<String> list=new ArrayList<>();
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<str.length();i++){
//            if((str.charAt(i)-'0')<10&&(str.charAt(i)-'0')>=0){
//                sb.append(str.charAt(i));
//                index++;
//            }else{
//                if(sb==null){
//                    continue;
//                }
//                list.add(sb.toString());
//                sb=null;
//                index=0;
//            }
//        }
//        String s=null;
//        for(int i=0;i<list.size();i++){
//            if(list.get(i).length()>s.length()){
//                s=list.get(i);
//            }
//        }
//        System.out.println(s);
//    }
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int count=0;
        int index=0;
        String s="";
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]-'0'>=0&&arr[i]-'0'<10){
                index=i;
                count=1;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]-'0'>=0&&arr[j]-'0'<10){
                        count++;
                        index=j;
                    }else{
                        break;
                    }
                }
                }
            if(count>s.length()){
                s=str.substring(i,index+1);
            }
            }

    System.out.println(s);
    }
}
