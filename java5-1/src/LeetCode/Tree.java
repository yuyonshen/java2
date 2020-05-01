package LeetCode;
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Tree {
    //每日一练
    //将两个有序链表链接为一个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode newHead=new ListNode(-1);
        ListNode tail=newHead;
        ListNode cur1=l1;
        ListNode cur2=l2;
        while(cur1!=null&&cur2!=null){
            if(cur1.val>cur2.val){
                tail.next=new ListNode(cur2.val);
                tail=tail.next;
                cur2=cur2.next;
            }else{
                tail.next=new ListNode(cur1.val);
                tail=tail.next;
                cur1=cur1.next;
            }

        }
        while(cur1!=null){
            tail.next=new ListNode(cur1.val);
            tail=tail.next;
            cur1=cur1.next;
        }
        while(cur2!=null){
            tail.next= new ListNode(cur2.val);
            tail=tail.next;
            cur2=cur2.next;
        }
        return newHead.next;
    }
}
