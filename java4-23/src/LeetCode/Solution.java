package LeetCode;

public class Solution {
    //永不有几种分法
    //给的硬币只有面值为25分,10 分,5分,1分
    //创意个参数为n,n 表示一共的面值,之后找出怎样可以组件出和为n的种类
    private static final int mod=1000000007;
    public int waysToChange(int n) {
        int ans = 0;
        for (int i = 0; i * 25 <= n; ++i) {
            int rest = n - i * 25;
            int a = rest / 10;
            int b = rest % 10 / 5;
            ans = (ans + (a + 1) * (a + b + 1) % mod) % mod;
        }
        return ans;
    }
    //顺序表打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        int a=matrix.length;
        int b=matrix[0].length;
        int[] arr=new int[a*b];

        int num=0;

            for(int i=0;i<matrix.length;i++){
                if(i%2==0){
                    for(int j=0;j<matrix[i].length;j++){
                        arr[num]=matrix[i][j];
                        num++;
                    }
                }else{
                    for(int x=matrix[i].length-1;x>=0;x--){
                        arr[num]=matrix[i][x];
                        num++;
                    }
                }
            }
       return arr;
    }
    public int[] spiralOrder1(int[][] matrix){
        //首先创建四个边界
        //上边界,下边界,左边界,有边界
        //上边界为0,下边界为高度,左边界为0,有边界为宽度
        //每次走玩一次边界需要更新边界,
        //首先创建四个边界的变量
        //左右边界
        int l=0,r=matrix[0].length-1;
        //上下边界
        int t=0,b=matrix.length-1;
        int[] arr=new int[(r+1)*(b+1)];
        if(matrix.length==0) {
            return new int[0];
        }
        int num=0;
        while(true){
           //左右先开始
            for(int i=0;i<=r;i++){
                arr[num]=matrix[t][i];
                num++;
            }
            t++;
            if(t>b){
                break;
            }
            for(int i=0;i<=b;i++){
                arr[num]=matrix[i][r];
                num++;
            }
            r--;
            if(r>l){
                break;
            }
            for(int i=r;i>=0;i--){
                arr[num]=matrix[b][i];
                num++;
            }
            b--;
            if(b-->t){
                break;
            }
            for(int i=b;i>=t;i--){
                arr[num]=matrix[i][l];
                num++;
            }
            l++;
            if(l>r){
                break;
            }
        }
        return arr;
    }
    //青蛙跳台阶可以有多少种方法
    //青蛙可以一次跳两节也可以一次跳一节
    //轻重可以找到规律为f(n)=f(n-1)+f(n-2);
    public int numWays(int n) {
        int[] res = new int[n + 1];
        if(n >= 0)
            res[0] = 1;
        if(n >= 1)
            res[1] = 1;
        for(int i = 2;i <= n;i++){
            res[i] += (res[i - 1] + res[i - 2]) % 1000000007;
        }
        return res[n];
    }
    //返回链表的倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
    int mid=size(head)-k;
    ListNode cur=head;
    for(int i=0;i<mid;i++){
        cur=cur.next;
    }
    return cur;
    }
    public int size(ListNode head){

        int size=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }
    //求数组中自己的和最大值
    public int maxSubArray(int[] nums) {
        int max=0;
        int arr=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]<0){
               max=nums[i];
           }
            for(int j=i+1;j<nums.length;j++){
                arr=arr+nums[j];
                max=Math.max(max,arr);

            }
            arr=0;
        }
        return max;
    }
}
class ListNode{
    int x;
    ListNode next;

    public ListNode(int x) {
        this.x = x;
    }
}
