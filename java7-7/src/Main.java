import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] str= new String[n];
        String[] str2=new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.next();
            str2[i]=sc.next();
        }
        List<String> list = new ArrayList<>();
        List<String> list2= new ArrayList<>();
        int[] arr=new int[3];
        for(int i=0;i<n;i++){

            if(("C".equals(str[i])&&"J".equals(str2[i]))){
                list.add(str[i]);
                arr[0]++;
            }else if("J".equals(str[i])&&"B".equals(str2[i])){
                list.add(str[i]);
                arr[0]++;
            }else if("B".equals(str[i])&&"C".equals(str2[i])){
                list.add(str[i]);
                arr[0]++;
            }
            else if(str[i].charAt(0)==str2[i].charAt(0)){
                arr[1]++;
            }else{
                arr[2]++;
                list2.add(str2[i]);
            }
        }
        System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        System.out.println(arr[2]+" "+arr[1]+" "+arr[0]);
        int a = 0,b=0,c=0;
        for (int i = 0; i < list.size(); i++) {
            if("B".equals(list.get(i))){
                a++;
            }else if("C".equals(list.get(i))){
                b++;
            }else{
                c++;
            }
        }
        if(a>=b&&a>=c){
            System.out.print("B"+" ");
        }else if(b>a&&b>c){
            System.out.print("C"+" ");
        }else{
            System.out.print("J"+" ");
        }
        int x=0,y=0,z=0;
        for (int i = 0; i < list2.size(); i++) {
            if("B".equals(list2.get(i))){
                x++;
            }else if("C".equals(list2.get(i))){
                y++;
            }else{
                z++;
            }
        }

        if(x>=y&&x>=z){
            System.out.print("B");
        }else if(y>x&&y>z){
            System.out.print("C");
        }else{
            System.out.print("J");
        }
    }
}
