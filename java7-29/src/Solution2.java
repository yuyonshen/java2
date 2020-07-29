import sun.security.util.Password;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution2 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int size1 = 0;
        int size2 = 0;
        ListNode cur = pHead1;
        ListNode cur2 = pHead2;
        while(cur != null){
            cur = cur.next;
            size1++;
        }
        while(cur2 != null){
            cur2 = cur2.next;
            size2++;
        }
        int num = Math.abs(size1 - size2);
        if(size1 > size2){
            while(num > 0){
                pHead1 = pHead1.next;
                num--;
            }
        }else {
            while(num > 0){
                pHead2 = pHead2.next;
                num--;
            }
        }
        while(pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;

        }
        return null;
    }
}
