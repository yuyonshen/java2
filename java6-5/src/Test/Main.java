package Test;


import java.util.Scanner;

public class Main{
    static int[] weight;
    static int count;
    static int N;
    public static void beibao(int s,int n){
        if(s == 0){
            count++;
            return;
        }
        if(s<0||(s>0&&n<1)) {
            return;
        }
        beibao(s-weight[n],n-1);
        beibao(s,n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            N = sc.nextInt();
            weight = new int[N+1];
            for(int i = 1;i<=N;i++){
                weight[i] = sc.nextInt();
            }
            beibao(40,N);
            System.out.println(count);

        }

    }

}
