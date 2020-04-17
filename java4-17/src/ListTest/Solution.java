package ListTest;

import java.awt.*;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //删除链表中给定的值
    public ListNode removeElements(ListNode head, int val) {
    //分为两种情况,删除头结点,和中间节点
        if(head==null){
            return null;
        }
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }

        }
        if(head.val==val){
            head=head.next;
        }
        return head;
    }
    //反转一个链表
    public ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode  newHead=null;//创建一个新的链表头结点
        ListNode cur=head;//cur的指向位置
        ListNode prev=null;//记录cur的上个位置
        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                newHead=cur;
            }
            //链表的反转,指向上一个节点
            cur.next=prev;
            //更新节点的位置
            prev=cur;
            cur=next;
        }
        return newHead;
    }
    //返回链表的中间节点
    public ListNode middleNode(ListNode head){
     int size=size(head);
     int index=size/2;
     ListNode cur=head;
     for(int i=0;i<index;i++){
         cur=cur.next;
     }
     return cur;
    }

    private int size(ListNode head) {
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }
    //输出链表中的倒数地k个节点
    public ListNode FindKthToTail(ListNode head,int k) {
        int size=size(head);
        int temp=size-k;
        if (k > size||head==null) {

            return null;
        }
        ListNode cur=head;
        for(int i=0;i<temp;i++){
            cur=cur.next;
        }
        return cur;
    }
    //给定两个有序链表,将和并为一个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1==null&&l2==null){
            return null;
        }
        ListNode newHead=new ListNode(0);
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
            tail.next=new ListNode(cur2.val);
            tail=tail.next;
            cur2=cur2.next;
        }
        return newHead.next;
    }
    //给定一个值小于x的值排在大于等于x值得前面
    public ListNode partition(ListNode pHead, int x) {
        //小于x值
        ListNode smallhead=new ListNode(0);
        ListNode smalltail=smallhead;
        //大于等于x值
        ListNode bighead=new ListNode(0);
        ListNode bigtail=bighead;

        if(pHead==null){
            return null;
        }
        if(pHead.next==null){
            return pHead;
        }
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.val<x){
                smalltail.next=new ListNode(cur.val);
                cur=cur.next;
                smalltail=smalltail.next;
            }else{
                bigtail.next=new ListNode(cur.val);
                cur=cur.next;
                bigtail=bigtail.next;
            }
        }
        smalltail.next=bighead.next;
        return smallhead.next;
    }
    //删除链表中的重复元素,返回头结点
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        ListNode newHead=new ListNode(0);
        ListNode tail=newHead;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tail.next=new ListNode(cur.val);
                cur=cur.next;
                tail=tail.next;
            }

        }
        return newHead.next;
    }
    //判断这个链表是否为回文链表
    public boolean chkPalindrome(ListNode A) {
       int size=size(A);
       int temp=size/2;
       ListNode B=A;
       for(int i=0;i<temp;i++){
           B=B.next;
       }
       //将B链表反转过来
        ListNode prev=null;
        ListNode cur=B;

        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                B=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        while(B!=null){
            if(B.val!=A.val){
                return false;
            }
            B=B.next;
            A=A.next;
        }
        return true;
    }
//找出两个链表的公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = size(headA);
        int size2 = size(headB);
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        if (size1 < size2) {
            int temp = size2 - size1;
            for (int i = 0; i < temp; i++) {
                cur2 = cur2.next;
            }
        } else {
            int temp = size1 - size2;
            for (int i = 0; i < temp; i++) {
                cur1 = cur1.next;
            }
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }
    //判断联保是否代环
    public boolean detectCycl(ListNode head){
        //根据开满指针来判断
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //给定一个链表返回入环的第一个节点
    public ListNode detectCycle(ListNode head){
        //还是是有快慢指针的方法找到第一个相遇的节点
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        //判断链表不带环
        if(fast==null||fast.next==null){
            return null;
        }
        ListNode cur=head;
        ListNode cur2=fast;
        while(cur!=cur2){
            cur=cur.next;
            cur2=cur.next;
        }
        return cur;
    }

}
