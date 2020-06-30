package LeetCode;

import java.util.*;

public class Main3{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                        //设置存放学生数目和操作数目的数组

        do{
        //System.out.println("请输入学生数目和操作数目:");
        int[] data = new int[2];

        data[0] = sc.nextInt();
        data[1] = sc.nextInt();
        //System.out.println("请输入学生成绩:");
        ArrayList<Integer> array = new ArrayList<Integer>();        //将成绩存入动态数组中
        for(int i=0;i < data[0];i++){
        array.add(sc.nextInt());
        }

        int time=0;
        char a;
        int b,c;
        while(time < data[1]){
        //  System.out.println("请输入操作命令:");
        a = sc.next().charAt(0);                                //获得一行字符
        b = sc.nextInt();
        c = sc.nextInt();

        if(a=='Q')
        {
        int start,end;
        if(b<c){
        start = b-1;
        end = c-1;
        }else{
        start = c-1;
        end = b-1;
        }

        int max = array.get(start);             //获得第一个查询的学生成绩
        for(int index=start+1;index<=end;index++){
        if(max<array.get(index)){
        max = array.get(index);
        }
        }
        System.out.println(+max);
        max = 0;
        }

        if(a=='U'){
        int index1 = b-1;
        int newValue = c;
        array.set(index1, newValue);
        }
        time++;
        }
        }   while(sc.hasNext());
        sc.close();
        }
        }


