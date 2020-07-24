package LeetCode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */

public class Solution2 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解决方法一:
     * 我们首先可以创建一个节点,之后进行尾插的方式
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 ==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = null;
        ListNode tail = null;
        while(list1 != null && list2 != null){
            ListNode p = list1.val > list2.val ? list2 : list1;
            if(p == list1){
                list1 = list1.next;
            }else{
                list2 = list2.next;
            }
            if(head == null){
                head = p;
                tail = p;
            }
            tail.next = p;
            tail = p;
        }
        if(list1 != null){
            tail.next = list1;
        }else{
            tail.next = list2;
        }
        return head;
    }

    /**
     * 解决方法2:
     * 我们可以使用递归的方式来解决
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode new_head = null;
        if(list1.val > list2.val){
            new_head = list2;
            list2 = list2.next;
        }
        else{
            new_head = list1;
            list1 = list1.next;
        }
        new_head.next = Merge2(list1,list2);
        return new_head;
    }
}
