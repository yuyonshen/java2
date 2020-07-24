package LeetCode;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
    /*
    解析：输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 0) {
            return null;
        }
        ListNode prev = head;
        ListNode last = head;
        while (prev != null && k > 0) {
            k--;
            prev = prev.next;
        }
        while (prev != null) {
            last = last.next;
            prev = prev.next;
        }
        return k > 0 ? null : last;
    }

}
