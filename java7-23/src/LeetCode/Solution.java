package LeetCode;


public class Solution {
    /**输入一个链表，反转链表后，输出新链表的表头
     * 解决方法一:
     * 我们首先创建三个指针.分别指向前三个节点,之后一次先后移动进行修改next的指向.
     */
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
            ListNode one =head;
            ListNode two = one.next;
            ListNode three = two.next;
            while(three != null){
                two.next = one;
                one = two;
                two = three;
                three = three.next;
            }
            head.next = null;
            two.next = one;
            head = two;
            return head;
    }

    /**
     * 解决方法二:
     * 1我们首先创建一个傀儡链表.
     * 2.之后我们遍历原来的链表将前面的每个节点插入行创建的链表的头部.(所谓的头插).
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = null;
        while(head != null){
            ListNode prev = head;
            head = head.next;
            prev.next = new_head;
            new_head = prev;
            /*
            先从原链表中去掉第一个节点
            ListNode p = head;
            head = head.next;
            //再将p标识的节点头查到新链表
            p.next = new_head;
            new_head = p;
             */
        }
        head = new_head;
        return head;
    }
}
