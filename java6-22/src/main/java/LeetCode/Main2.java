package LeetCode;

public class Main2 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode pHead, int x) {
        ListNode small=new ListNode(-1);
        ListNode smalltail=small;
        ListNode big=new ListNode(-1);
        ListNode bigtail=big;
        ListNode cur=pHead;
        while(cur.next!=null){
            if(cur.val<x){
                 smalltail=cur;
                smalltail=smalltail.next;
                cur=cur.next;
            }else{
                bigtail=cur;
                bigtail=bigtail.next;
                cur=cur.next;
            }
        }
        smalltail.next=big.next;
        return small.next;
    }


    public ListNode partition2(ListNode pHead, int x) {

        if(pHead == null){
            return null;
        }

        ListNode smaller = new ListNode(-1);
        ListNode  bigger = new ListNode(-1);
        ListNode cur = pHead, pS = smaller, pB = bigger;

        while(cur != null){
            if(cur.val < x){
                pS.next = cur;
                pS = pS.next;
            }else{
                pB.next = cur;
                pB = pB.next;
            }
            cur = cur.next;
        }
        // 一定要将最后的节点的指针域置为 null ！！！
        pB.next = null;
        // 将 smaller 链表最后一个节点的指针域放置 bigger 链表的头指针
        pS.next = bigger.next;

        // 返回头指针
        return smaller.next;
    }
}
}
