package LeetCode;
import java.util.ArrayList;

class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

/**
 * 这个题是将链表中的数字按照逆序的方式输出.
 * 我们采用的是递归的方式来解决.
 */
public class Soution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Helper(list, listNode);
        return list;

    }

    public static void Helper(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        Helper(list, listNode.next);
        list.add(listNode.val);
    }
}